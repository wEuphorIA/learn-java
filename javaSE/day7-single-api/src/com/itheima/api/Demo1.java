package com.itheima.api;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 上午10:18
 */
/*
    String类：代表字符串，提供了很多操作字符串的方法
    String类的对象：
        方式一：直接赋值（例如："abc"）
        方式二：new String类的对象
            public String()创建一个空白字符串对象，不含有任何内容
            public String(String original)根据传入的字符串内容，来创建字符串对象
            public String(char[] chars)根据字符数组的内容，来创建字符串对象
            public String(byte[] bytes)根据字节数组的内容，来创建字符串对象
 */
public class Demo1 {
    public static void main(String[] args) {

        //方式一：直接赋值（例如："abc"）
        String s = "abc";
        System.out.println(s);

        //方式二：new String类的对象
        //public String()创建一个空白字符串对象，不含有任何内容
        String s1 = new String();
        s1 += "abc";
        System.out.println(s1);

        //public String(String original)根据传入的字符串内容，来创建字符串对象
        String s2 = new String("abc");
        System.out.println(s2);

        //public String(char[] value)根据字符数组的内容，来创建字符串对象
        char[] ch = {'a','b','c'};
        String s3 = new String(ch);
        System.out.println(s3);

        //public String(byte[] bytes)根据字节数组的内容，来创建字符串对象
        byte[] b = {97,98,99};
        String s4 = new String(b);
        System.out.println(s4);


    }
}
