package com.itheima.d1_network.demo6;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/18 下午3:20 */
public class ServiceRead implements Runnable{

    private Socket socket;

    public ServiceRead(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            while (true) {
                // System.out.println(dis.readInt());
                System.out.println("读取到的数据为：" + dis.readUTF());
                System.out.println("ip:为" + socket.getLocalAddress().getHostAddress());
                System.out.println("端口为" + socket.getPort());

            }
        } catch (IOException e) {
            System.out.println("客户端下线了" + socket.getInetAddress().getHostAddress());
        }
    }
}
