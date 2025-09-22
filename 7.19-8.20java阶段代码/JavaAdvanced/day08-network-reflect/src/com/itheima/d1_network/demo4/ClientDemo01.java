package com.itheima.d1_network.demo4;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
  tcp客户端发送数据
    构造器：
      Socket(String host,int port)：创建发送端的Socket对象与服务端连接，参数为服务端程序的ip和端口
    常用方法：
      InputStream getOutputStream()：获得字节输出流对象
      OutputStream getInputStream()：获得字节输入流对象
 */
public class ClientDemo01 {
    public static void main(String[] args) throws Exception {
        //"192.168.12.55"
        //1.创建发送端的Socket对象,创建连接
        Socket client = new Socket(InetAddress.getLocalHost(), 10086);

        //2.获取输出流和数据
        OutputStream os = client.getOutputStream();

        //用特殊流封装数据
        DataOutputStream dos = new DataOutputStream(os);


        dos.writeInt(1);
        dos.writeUTF("Ciallo～(∠・ω＜)⌒☆");

        client.close();

    }
}
