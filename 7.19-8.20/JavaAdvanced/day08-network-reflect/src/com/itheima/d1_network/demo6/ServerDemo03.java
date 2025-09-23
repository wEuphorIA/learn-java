package com.itheima.d1_network.demo6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
    tcp服务端利用 多线程 接收多个客户端发送过来的消息
 */
public class ServerDemo03 {
    public static void main(String[] args) throws IOException {
        //创建服务端对象
        ServerSocket server = new ServerSocket(10086);

        while (true) {
            Socket accept = server.accept();
            System.out.println("客户端上线了：" + accept.getInetAddress().getHostAddress());
            new Thread(new ServiceRead(accept)).start();
        }
    }
}


