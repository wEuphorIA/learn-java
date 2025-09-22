package day08.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/18 下午7:52 */
public class Producer {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 5672);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

            out.println("PRODUCER");  // 发送身份标识

            System.out.println("生产者已连接（输入消息，exit退出）:");
            String message;
            while (!(message = in.readLine()).equalsIgnoreCase("exit")) {
                out.println(message);  // 自动添加\n
                System.out.println("[DEBUG] 已发送: " + message);  // 调试输出
                Thread.sleep(1000);  // 延迟1秒，方便观察
            }
        } catch (IOException e) {
            System.err.println("连接失败: " + e.getMessage());
        }
    }
}
