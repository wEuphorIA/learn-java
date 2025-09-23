package com.itheima.d1_network.demo4;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
  tcp服务端代码接收数据
    构造器
        ServerSocket(int port)：注册服务端端口
    常用方法：
        Socket accept()：等待接收客户端的Socket通信连接，连接成功返回Socket对象与客户端建立端到端通信
 */
// 端口被占用解决方案:
// ① 如果你知道哪个程序占用了该端口,可以手动结束即可
// ② 如果不知道哪一个程序占用了该端口,可以使用cmd命令 netstat -ano | findStr 端口号,查找哪一个程序占了了,直接杀死
public class ServerDemo01 {
    public static void main(String[] args) throws Exception {

        //创建服务端对象
        ServerSocket server = new ServerSocket(10086);

        Socket accept = server.accept();

        InputStream is = accept.getInputStream();
        DataInputStream dis = new DataInputStream(is);

        System.out.println(dis.readInt());
        System.out.println(dis.readUTF());


        accept.close();
        server.close();
    }
}
