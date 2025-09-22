package com.itheima.d3_charset;

import java.util.Arrays;

public class CharsetDemo1 {
    public static void main(String[] args) throws Exception {
        // 目标:掌握字符的编解码
        String str = "黑马程序员aaa666";
        // 给字符串编码
        // byte[] getBytes() : 默认曹勇UTF-8字符集编码
        byte[] bytes1 = str.getBytes();
        //  byte[] getBytes(String charsetName) :指定字符集来编码
        byte[] bytes2 = str.getBytes("gbk");

        System.out.println(bytes2.length);
        System.out.println(Arrays.toString(bytes2));

        // 给字符串解码
        // public String(byte[] bytes) 根据字节数组的内容，来创建字符串对象,默认采用utf-8解码
        String s1 = new String(bytes1);
        System.out.println(s1);

        // String s2 = new String(bytes2);
        // System.out.println(s2);

        // public String(byte[] bytes,String charsetName) 根据字节数组的内容，来创建字符串对象，并指定编码解码
        String s2 = new String(bytes2,"gbk");
        System.out.println(s2);
    }
}
