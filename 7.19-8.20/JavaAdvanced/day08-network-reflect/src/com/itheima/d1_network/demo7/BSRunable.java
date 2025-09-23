package com.itheima.d1_network.demo7;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/18 下午4:26 */
public class BSRunable implements Runnable{

    private Socket socket;

    public BSRunable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintStream ps = new PrintStream(outputStream);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println(); // 必须换一行
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<meta charset='utf-8'>");
            ps.println("<title>");
            ps.println("黑马程序员");
            ps.println("</title>");
            ps.println("</head>");
            ps.println("<body>");
            ps.println("<h1 style='color:red;font-size=20px'>听黑马讲师讲Java</h1>");
            // 响应一个黑马程序员的log展示
            ps.println("<img src='https://www.itheima.com/images/logo.png'>");
            ps.println("</body>");
            ps.println("</html>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
