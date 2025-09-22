package com.itheima.d4_io.d3_buffer;

import java.io.*;

public class Demo03 {

    private static final String SOURCE_PATH = "D:\\00-西安黑马AI智能应用开发就业112班\\JavaSE进阶-AI\\day05-集合、Stream流\\视频\\02-set集合体系以及特点.mp4";
    private static final String DEST_PATH = "D:\\";

    public static void main(String[] args) {
        //性能分析
        // copyFileByByte(); //低级的字节流，一个字节一个字节的复制
        copyFileByByteArray(); //低级的字节流按照字节数组的形式复制文件
        copyFileByBuffer();//高级的缓冲字节流按照一个字节一个字节的复制
        copyFileByBufferArray();//高级的缓冲字节流按照字节数组的形式复制文件
    }

    //使用低级的字节流按照一个一个字节的形式复制文件
    public static void copyFileByByte() {
        long start = System.currentTimeMillis(); //获取当前时间的毫秒值（时间戳）
        try (
                //创建一个字节输入流，用于读取文件
                InputStream is = new FileInputStream(SOURCE_PATH);
                //创建一个字节输出流，用于向指定路径下写入文件
                OutputStream os = new FileOutputStream(DEST_PATH + "1.mp4");
        ) {
            //开始复制
            int len = 0;
            while ((len = is.read()) != -1) {
                os.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("低级的字节流按照字节数组的形式复制文件，耗时："+(end-start)/1000.0+"s");
    }

    //使用低级的字节流按照字节数组的形式复制文件。
    public static void copyFileByByteArray() {
        long start = System.currentTimeMillis(); //获取当前时间的毫秒值（时间戳）
        try (
                //创建一个字节输入流，用于读取文件
                InputStream is = new FileInputStream(SOURCE_PATH);
                //创建一个字节输出流，用于向指定路径下写入文件
                OutputStream os = new FileOutputStream(DEST_PATH + "2.mp4");
        ) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("低级的字节流按照字节数组的形式复制文件，耗时："+(end-start)/1000.0+"s");
    }

    //使用高级的缓冲字节流按照一个一个字节的形式复制文件
    public static void copyFileByBuffer() {
        long start = System.currentTimeMillis(); //获取当前时间的毫秒值（时间戳）
        try (
                //创建一个字节输入流，用于读取文件
                InputStream is = new FileInputStream(SOURCE_PATH);
                //创建一个字节输出流，用于向指定路径下写入文件
                OutputStream os = new FileOutputStream(DEST_PATH + "3.mp4");
                //把低级的字节输入和输出流包装成一个高级的缓冲字节输入和输出流
                InputStream bis = new BufferedInputStream(is);
                OutputStream bos = new BufferedOutputStream(os);
        ) {
            //开始复制
            int len = 0;
            while ((len = bis.read()) != -1) {
                bos.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("高级的缓冲字节流按照一个字节一个字节的复制，耗时："+(end-start)/1000.0+"s");
    }

    //使用高级的缓冲字节流按照字节数组的形式复制文件
    public static void copyFileByBufferArray() {
        long start = System.currentTimeMillis(); //获取当前时间的毫秒值（时间戳）
        try (
                //创建一个字节输入流，用于读取文件
                InputStream is = new FileInputStream(SOURCE_PATH);
                //创建一个字节输出流，用于向指定路径下写入文件
                OutputStream os = new FileOutputStream(DEST_PATH + "4.mp4");

                //把低级的字节输入和输出流包装成一个高级的缓冲字节输入和输出流
                InputStream bis = new BufferedInputStream(is);
                OutputStream bos = new BufferedOutputStream(os);

        ) {
            //创建一个字节数组
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("高级的缓冲字节流按照字节数组的形式复制文件，耗时："+(end-start)/1000.0+"s");
    }
}