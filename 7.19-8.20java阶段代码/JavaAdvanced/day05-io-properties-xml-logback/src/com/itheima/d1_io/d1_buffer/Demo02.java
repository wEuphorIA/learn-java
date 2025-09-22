package com.itheima.d1_io.d1_buffer;


import java.io.*;

/*
需求：定义方法分别使用原始的字节流，以及字节缓冲流复制一个文件(10MB就行)，记录耗时。
测试内容：
    1 使用原始的字节流按照一个一个字节的形式复制文件。
    2 使用原始的字节流按照字节数组的形式复制文件。
    3 使用高效的缓冲字节流按照一个一个字节的形式复制文件。
    4 使用高效的缓冲字节流按照字节数组的形式复制文件。
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        copy1(); //1 使用原始的字节流按照一个一个字节的形式复制文件。
        copy2(); //2 使用原始的字节流按照字节数组的形式复制文件。
        copy3(); //3 使用高效的缓冲字节流按照一个一个字节的形式复制文件.
        copy4(); //4 使用高效的缓冲字节流按照字节数组的形式复制文件。
    }

    //1 使用原始的字节流按照一个一个字节的形式复制文件。
    public static void copy1() throws IOException {
        //获取开始时间，毫秒值
        long start = System.currentTimeMillis();

        //1 创建字节输入流和输出流对象
        FileInputStream fis = new FileInputStream("要读取的文件路径");
        FileOutputStream fos = new FileOutputStream("要写入的文件路径");
        //2 循环读写，一次读写一个字节
        int by=0;
        while ((by=fis.read())!=-1){
            fos.write(by);
        }
        //3 释放资源
        fis.close();
        fos.close();

        //获取结束时间，毫秒值
        long end = System.currentTimeMillis();
        System.out.println("1 使用原始的字节流按照一个一个字节的形式复制文件 = " + (end-start));
    }


    //2 使用原始的字节流按照字节数组的形式复制文件。
    public static void copy2() throws IOException {
        //获取开始时间，毫秒值
        long start = System.currentTimeMillis();

        //1 创建字节输入流和输出流对象
        FileInputStream fis = new FileInputStream("要读取的文件路径");
        FileOutputStream fos = new FileOutputStream("要写入的文件路径");
        //2 循环读写，一次读写一个字节数组
        int len=0;
        byte[] bytes=new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        //3 释放资源
        fis.close();
        fos.close();

        //获取结束时间，毫秒值
        long end = System.currentTimeMillis();
        System.out.println("2 使用原始的字节流按照字节数组的形式复制文件 = " + (end-start));
    }


    //3 使用高效的缓冲字节流按照一个一个字节的形式复制文件.
    public static void copy3() throws IOException {
        //获取开始时间，毫秒值
        long start = System.currentTimeMillis();

        //1 创建字节缓冲输入流和输出流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("要读取的文件路径"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("要写入的文件路径"));
        //2 循环读写，一次读写一个字节
        int by=0;
        while ((by=bis.read())!=-1){
            bos.write(by);
        }
        //3 释放资源
        bis.close();
        bos.close();

        //获取结束时间，毫秒值
        long end = System.currentTimeMillis();
        System.out.println("3 使用高效的缓冲字节流按照一个一个字节的形式复制文件 = " + (end-start));
    }


    //4 使用高效的缓冲字节流按照字节数组的形式复制文件。
    public static void copy4() throws IOException {
        //获取开始时间，毫秒值
        long start = System.currentTimeMillis();

        //1 创建字节缓冲输入流和输出流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("要读取的文件路径"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("要写入的文件路径"));
        //2 循环读写，一次读写一个字节数组
        int len=0;
        byte[] bytes=new byte[1024];
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        //3 释放资源
        bis.close();
        bos.close();

        //获取结束时间，毫秒值
        long end = System.currentTimeMillis();
        System.out.println("4 使用高效的缓冲字节流按照字节数组的形式复制文件 = " + (end-start));
    }
}
