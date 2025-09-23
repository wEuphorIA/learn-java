package com.itheima.d1_network.demo7;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleHttpProxy {
    public static void main(String[] args) throws IOException {
        // 创建服务器Socket，监听8080端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("代理服务器已启动，监听端口8080...");

        while (true) {
            Socket clientSocket = null;
            try {
                // 接受客户端连接
                clientSocket = serverSocket.accept();
                System.out.println("接收到客户端连接：" + clientSocket.getInetAddress());

                // 获取客户端输入流（请求数据）
                BufferedReader clientReader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                
                // 读取请求的第一行（请求行）
                String requestLine = clientReader.readLine();
                if (requestLine == null) continue;
                
                System.out.println("客户端请求：" + requestLine);

                // 解析请求行，获取请求方法和路径
                String[] requestParts = requestLine.split(" ");
                String method = requestParts[0];
                String path = requestParts[1];

                // 替换原来的代理逻辑部分
                String targetUrl = "http://www.baidu.com" + path;  // 强制HTTP
                HttpURLConnection targetConnection = (HttpURLConnection) new URL(targetUrl).openConnection();
                targetConnection.setRequestMethod(method);

// 复制请求头
                String line;
                while ((line = clientReader.readLine()) != null && !line.isEmpty()) {
                    String[] header = line.split(":", 2);
                    if (header.length == 2) {
                        targetConnection.setRequestProperty(header[0].trim(), header[1].trim());
                    }
                }

// 转发响应
                targetConnection.connect();
                OutputStream clientOutput = clientSocket.getOutputStream();
                clientOutput.write(("HTTP/1.1 " + targetConnection.getResponseCode() + " OK\r\n").getBytes());
                for (Map.Entry<String, List<String>> header : targetConnection.getHeaderFields().entrySet()) {
                    if (header.getKey() != null) {
                        clientOutput.write((header.getKey() + ": " + String.join(",", header.getValue()) + "\r\n").getBytes());
                    }
                }
                clientOutput.write("\r\n".getBytes());  // 空行

// 二进制数据转发
                try (InputStream targetInput = targetConnection.getInputStream()) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = targetInput.read(buffer)) != -1) {
                        clientOutput.write(buffer, 0, bytesRead);
                    }
                }

                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (clientSocket != null) {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    // 获取HTTP状态码对应的消息
    private static String getStatusMessage(int code) {
        switch (code) {
            case 200: return "OK";
            case 404: return "Not Found";
            case 500: return "Internal Server Error";
            default: return "Unknown";
        }
    }
}