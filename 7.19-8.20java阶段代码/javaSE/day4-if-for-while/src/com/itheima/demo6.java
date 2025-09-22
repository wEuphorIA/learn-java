package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 上午11:56
 */
/*
    案例：求和
    需求：求1-10之间的数据和，并把求和结果在控制台输出。
    实现步骤：
        //1 在循环外定义一个求和变量sum，初始值是0；
        //2 使用循环生成1~10之间的整数
        //3 在循环中将生成的每个数累加到sum身上
        //4 循环结束后，打印sum的值即为求和结果
 */
public class demo6 {
    public static void main(String[] args) {
        //1 在循环外定义一个求和变量sum，初始值是0；
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            //2 使用循环生成1~10之间的整数
            //3 在循环中将生成的每个数累加到sum身上
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}
