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
 @date 2025/8/18 下午7:57 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 5672);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // 1. 发送消费者标识
            out.println("CONSUMER");
            System.out.println("消费者已注册，等待消息...");

            // 2. 持续监听消息
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("收到消息: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
