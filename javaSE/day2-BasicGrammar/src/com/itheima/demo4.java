package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 上午10:51
 */
/*
    使用变量的注意事项：
        1、变量要先声明/定义才能使用
        2、变量是什么类型，就必须装什么类型的数据
        3、变量是从定义开始到"}"截止的范围内有效;
        4、同一个{}范围内，变量的名称不能一样
        5、变量定义的时候可以不赋初始值；但在使用时，变量里必须有值。
 */
public class demo4 {
    public static void main(String[] args) {

        // 1、变量要先声明/定义才能使用
        // System.out.println(age);

        // 2、变量是什么类型，就必须装什么类型的数据
        //int age = "s";

        {
            int age = 18;

            // 4、同一个{}范围内，变量的名称不能一样
            // int age = 19;

        }

        // 3、变量是从定义开始到"}"截止的范围内有效;
        // System.out.println(age);

        int age;

        // 变量定义的时候可以不赋初始值；但在使用时，变量里必须有值。
        // System.out.println(age);

        char letterA = 65;
        System.out.println(letterA);

    }
}
