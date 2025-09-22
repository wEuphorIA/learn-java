package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午4:25
 */
/*
    需求：求两个数中的最大值，键盘录入两个数据，将两个数中的较大值输出。
    考查技术点：键盘录入、三元运算符的使用。
    步骤：
        //1 创建Scanner扫描器对象
        //2 提示并获取两个数
        //3 使用三元运算符判断两个数中的较大值
        //4 输出结果
 */
public class Demo9 {
    public static void main(String[] args) {

        //1 创建Scanner扫描器对象
        Scanner scanner = new Scanner(System.in);

        //2 提示并获取两个数
        System.out.println("请输入第一个数：");
        int a = scanner.nextInt();
        System.out.println("请输入第二个数：");
        int b = scanner.nextInt();

        //3 使用三元运算符判断两个数中的最大值
        System.out.println("最大值为" + (a > b ? a : b));
    }
}
