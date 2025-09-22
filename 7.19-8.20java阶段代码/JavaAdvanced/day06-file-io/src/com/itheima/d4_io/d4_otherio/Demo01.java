package com.itheima.d4_io.d4_otherio;

//目标：了解InputStreamReader和OutputStreamWriter的使用

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * InputStreamReader(InputStream is)：几乎不用，可以把原始的字节流按照代码默认编码转换成字符输入流
 * InputStreamReader(InputStream is ，String charset)：可以把原始的字节流按照指定编码转换成字符输入流
 * 需求：使用字符输入转换流读取f-gbk.txt文件内容，使其读取内容不乱码
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //需求：使用字符输入流读取f-gbk.txt文件内容，观察读取结果。
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("day06-file-io/src/f-gbk.txt"),"GBK"));
        String line;
        while ((line =br.readLine()) != null){
            System.out.println(line);
        }

    }
}
