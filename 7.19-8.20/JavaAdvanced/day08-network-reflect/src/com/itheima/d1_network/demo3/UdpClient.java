package com.itheima.d1_network.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    public static void main(String[] args) throws IOException {
        //目标：UDP的多发多收（客户端）
        //创建udp对象
        DatagramSocket client = new DatagramSocket();

        //创建数据
        byte[] data = "Ciallo～(∠・ω＜)⌒☆".getBytes();
        int i = 0;
        while (i < 5) {
            InetAddress byName = InetAddress.getByName("192.168.200.1");
            DatagramPacket dp = new DatagramPacket(data, data.length, byName, 10086);
            client.send(dp);
            i++;
        }

    }
}
