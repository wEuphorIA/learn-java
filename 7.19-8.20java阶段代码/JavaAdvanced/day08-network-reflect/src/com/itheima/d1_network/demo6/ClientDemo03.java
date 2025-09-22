package com.itheima.d1_network.demo6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
    多个tcp客户端多发消息
 */
public class ClientDemo03 {
    public static void main(String[] args) throws IOException {
        //"192.168.12.55"
        //127.0.0.1
        //1.创建发送端的Socket对象,创建连接
        Socket client = new Socket("127.0.0.1", 10086);

        //2.获取输出流和数据
        OutputStream os = client.getOutputStream();

        //用特殊流封装数据
        DataOutputStream dos = new DataOutputStream(os);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入内容");
            String s = scanner.nextLine();
            dos.writeUTF("Ciallo～(∠・ω＜)⌒☆");
            dos.writeUTF(s);
            if (s.equals("886")){
                client.close();
                break;
            }
            dos.flush();
        }
    }
}
