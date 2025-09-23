package com.itheima.d1_network.demo9;

public class Demo2String {
    public static void main(String[] args) {
        //掌握字符串的拼接操作
        // method1();
       // method2();
        method3();
    }

    //演示使用原始的方式拼接
    public static void method1() {
        String s = ""; // "" ->  "abc"  -> "abcabc"  -> "abcabcabc"
        //循环100万次
        for (int i = 0; i < 1000000; i++) {
            s = s + "abc";
        }
        System.out.println(s);
    }

    //使用StringBuilder 拼接  线程不安全，但是速度快
    public static void method2() {
        StringBuilder sb = new StringBuilder();//StringBuilder知识处理字符的一种手段，最终要的还是字符串String
        //循环100万次
        for (int i = 0; i < 1000000; i++) {
            sb.append("abc");
        }
        System.out.println(sb.toString());
    }

    //使用StringBuffer 拼接 线程安全，但是速度慢
    public static void method3() {
        StringBuffer sb = new StringBuffer();//StringBuffer知识处理字符的一种手段，最终要的还是字符串String
        //循环100万次
        for (int i = 0; i < 1000000; i++) {
            sb.append("abc");
        }
        System.out.println(sb.toString());
    }
}
