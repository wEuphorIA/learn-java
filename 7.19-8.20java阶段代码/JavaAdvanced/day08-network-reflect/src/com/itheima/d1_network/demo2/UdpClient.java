package com.itheima.d1_network.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        //目标：快速入门UDP协议发送数据（客户端）

        //创建udp对象
        DatagramSocket client = new DatagramSocket();

        //创建数据
        byte[] data = "hello udp wyk".getBytes();

        //
        InetAddress byName = InetAddress.getByName("192.168.12.30");

        DatagramPacket dp = new DatagramPacket(data, data.length, byName, 10086);

        client.send(dp);



        client.close();


    }
}
