package com.itheima.d3_charset;

import java.io.UnsupportedEncodingException;

/*
    编码：String提供了如下成员方法
        byte[] getBytes() 使用平台的默认字符集将该 String编码为一系列字节，将结果存储到新的字节数组中
        byte[] getBytes(String charsetName) 使用指定的字符集将该 String编码为一系列字节，将结果存储到新的字节数组中

    解码：String提供了如下构造方法
        String (byte[] bytes) 通过使用平台的默认字符集解码指定的字节数组来构造新的 String
        String (byte[] bytes, String charsetName) 通过指定的字符集解码指定的字节数组来构造新的 String
    注意：编解码使用的字符集必须一样，否则出现乱码。英文和数字不会乱码，因为其他字符集都兼容ASCII字符集
 */
public class Demo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s="我ai你";
        //编码

        //解码
    }
}
