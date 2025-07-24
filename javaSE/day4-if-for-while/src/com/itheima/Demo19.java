package com.itheima;

import java.util.Random;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午5:23
 */
/*
    Random类：生成随机数
    使用步骤：
        第一步：导包，告诉程序去jdk哪个包中找Random（可以自动导入）
        第二步：创建Random随机数对象
        第三步：调用nextInt(n)功能生成一个随机整数
 */
public class Demo19 {
    public static void main(String[] args) {

        // 第一步：导包，告诉程序去jdk哪个包中找Random（可以自动导入）
        // 第二步：创建Random随机数对象
        Random r = new Random();

        //第三步：调用nextInt(n)功能生成一个随机整数
        int i = r.nextInt(1,100);

        System.out.println(i);

    }
}
