package com.itheima.d1_network.demo7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        //目标：使用多线程改造TCP服务端程序,接收浏览器请求,返回页面
        ServerSocket server = new ServerSocket(8080);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                16,
                32,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5)
        );


        while (true){
            Socket socket = server.accept();
            pool.execute(new BSRunable(socket));
        }
    }
}
