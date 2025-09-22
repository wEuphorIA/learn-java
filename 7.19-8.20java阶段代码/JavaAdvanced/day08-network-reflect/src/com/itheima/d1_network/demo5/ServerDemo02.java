package com.itheima.d1_network.demo5;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 tcp服务端多收消息
 */
public class ServerDemo02 {
    public static void main(String[] args) throws Exception {

        //创建服务端对象
        ServerSocket server = new ServerSocket(10086);

        Socket accept = server.accept();

        InputStream is = accept.getInputStream();
        DataInputStream dis = new DataInputStream(is);


        while (true) {
            // System.out.println(dis.readInt());
            System.out.println("读取到的数据为：" + dis.readUTF());
            System.out.println("ip:为" + accept.getLocalAddress());
        }
    }
}
