package com.itheima.d1_network.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        //目标：UDP的多发多收（服务端）
        //目标：完成UPD服务端代码编写
        DatagramSocket server = new DatagramSocket(10086);

        byte[] data = new byte[1024];

        DatagramPacket dp = new DatagramPacket(data, data.length);
        while (true){
            server.receive(dp);
            System.out.println("打印的数据是" + new String(data,0,dp.getLength()));
            System.out.println("IP为" + dp.getAddress().getHostAddress());
        }

    }
}
