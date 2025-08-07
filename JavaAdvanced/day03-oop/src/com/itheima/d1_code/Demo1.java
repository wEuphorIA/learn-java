package com.itheima.d1_code;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 上午9:07 */
public class Demo1 {
    static {
        System.out.println("静态代码块执行了");
        // 静态代码块
        //静态代码块作用
        //只会被执行一次
        //给静态变量赋值
    }

    public static void main(String[] args) {
        System.out.println("main方法执行了");
    }
}
