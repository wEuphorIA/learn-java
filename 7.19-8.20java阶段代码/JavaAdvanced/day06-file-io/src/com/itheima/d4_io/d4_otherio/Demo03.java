package com.itheima.d4_io.d4_otherio;

//目标：了解DataOutputStream和DataInputStream的使用
/**
 * DataOutputStream构造方法：
 *   DataOutputStream(OutputStream out)：允许把数据和其类型一并写出去，适用于将数据通过网络写出去。
 * 成员方法：
 *   public final void writeInt (int v) ：将int类型的数据写入基础的字节输出流
 *   public final void writeUTF(String s)：将字符串数据以UTF-8编码成字节写入基础的字节输出流
 *   需求：将数字100写出到当前模块下的c.txt中,将字符串"我爱Java"按照utf-8编码方式写出到当前模块下的d.txt中
 */

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * DataInputStream构造方法：
 *   DataInputStream(InputStream is)：用于读取数据输出流写出去的数据，适用于从网络中读取数据。
 * 成员方法：
 *   public final int readInt() ： 读取int类型的数据返回
 *   public final String readUTF() ： 读取字符串数（UTF-8）据返回
 *  需求：使用DataInputStream流读取当前模块下的d.txt中的内容
 */

public class Demo03 {
    public static void main(String[] args) throws Exception {
        // DataOutputStream dos = new DataOutputStream(new FileOutputStream("day06-file-io\\src\\c.txt"));
        // dos.write(18);
        // dos.writeBoolean(true);
        // dos.writeChar('a');
        // dos.writeUTF("hello,world");

        DataInputStream dis = new DataInputStream(new FileInputStream("day06-file-io\\src\\c.txt"));
        System.out.println(dis.read());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        System.out.println(dis.readUTF());



    }
}
