package com.itheima.d4_io.d1_byteio;

//目标：掌握使用文件字节输入流每次读取一个字节或者一个字节数组
public class Demo01 {
    public static void main(String[] args){
    /*
       构造器：
           FileInputStream(File file)：创建字节输入流管道与源文件对象接通
           FileInputStream(String pathname)：创建字节输入流管道与源文件路径接通

       读取文件字节数据的方法：
           int read()：每次读取一个字节返回，如果字节已经没有可读的返回-1、
           int read(byte[] buffer)：每次读取一个字节数组，返回读取的字节个数，如果字节已经没有可读的返回-1

       释放资源：
           public void close() throws IOException public void close() throws IOException

       需求：在当前模块下，创建一个a.txt文件，文件中有内容：我爱java,使用 字节输入流 读取文件数据，打印到控制台
    */
    }
}
