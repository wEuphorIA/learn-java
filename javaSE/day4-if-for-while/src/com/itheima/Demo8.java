package com.itheima;


/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 上午11:58
 */
/*
    案例：求和
    需求：求1-10之间的奇数和，并把求和结果在控制台输出。
    实现步骤：
        //1 在循环外定义一个求和变量sum，初始值是0；
        //2 使用循环生成1~10之间的奇数
        //3 在循环中，将生成的奇数累加到sum身上
        //4 循环结束后，打印sum的值即为求和结果
 */
public class Demo8 {
    public static void main(String[] args) {

        //1 在循环外定义一个求和变量sum，初始值是0；
        int sum = 0;
        //2 使用循环生成1~10之间的奇数
        for (int i = 1; i <= 10; i+=2) {
            //3 在循环中，将生成的奇数累加到sum身上
            sum += i;
        }
        //4 循环结束后，打印sum的值即为求和结果
        System.out.println("sum = " + sum);

    }
}
