package com.itheima.d1_charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/30 上午10:36
 */
public class Demo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = "hello world黑马程序员";

        //编码
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();
        byte[] bytes1 = s.getBytes("gbk");
        for (byte b : bytes1) {
            System.out.print(b + " ");
        }
        System.out.println();

        //解码
        String s1 = new String(bytes);
        System.out.println(s1);
        String s2 = new String(bytes1,"gbk");
        System.out.println(s2);

        //解码和编码使用的字符集必须一样不然会报错
        String s3 = new String(bytes1, StandardCharsets.UTF_8);
        System.out.println(s3);
    }
}
