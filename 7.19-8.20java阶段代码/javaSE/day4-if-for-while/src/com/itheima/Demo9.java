package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午12:17
 */
/*
    案例：求水仙花数
    需求：控制台输出所有的"水仙花数"，水仙花数必须满足如下2个要求：
        1、仙花数是一个三位数
        2、仙花数的个位、十位、百位的数字立方和等于原数。例如：153
    实现步骤：
        1、定义一个for循环从“100一直到999"
        2、在循环中获取每个数的个位、十位、百位数字。
        3、使用if判断：个位、十位、百位的数字立方和是否等于原数，等于则输出该数据
    需求：统计水仙花数的个数
        ①、在循环外定义一个变量count，初始值为0，用于统计水仙花数的个数
        ②、在循环中判断，每输出一个水仙花数count就+1
 */
public class Demo9 {
    public static void main(String[] args) {
        //在循环外定义一个变量count，初始值为0，用于统计水仙花数的个数
        int count = 0;

        // 1、定义一个for循环从“100一直到999"
        for (int i = 100; i <= 999; i++) {
            // 2、在循环中获取每个数的个位、十位、百位数字。
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            // 3、使用if判断：个位、十位、百位的数字立方和是否等于原数，等于则输出该数据
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println(i);
                count++;
            }
        }

        System.out.println("count = " + count);
    }

}