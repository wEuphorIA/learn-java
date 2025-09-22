package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午4:56
 */
/*
    需求：设计一个可以执行基本数学运算（加、减、乘、除）的计算器程序。
    功能描述：
        1、用户输入两个数字、一个运算符(+、-、*、/)
        2、根据所选运算符执行相应的数学运算，显示运算结果。
    涉及的知识点：Scanner键盘录入，算术运算符、分支结构。
    实现步骤：
        //1 创建Scanner扫描器对象
        //2 提示并获取用户输入的整数和运算符
        //3 使用switch语句判断运算符
        //4 根据不同的运算符执行对应的操作并打印结果
 */
public class Demo18 {
    public static void main(String[] args) {

        //1 创建Scanner扫描器对象
        Scanner sc = new Scanner(System.in);

        //2 提示并获取用户输入的整数和运算符
        System.out.println("请输入第一个整数：");
        int a = sc.nextInt();
        System.out.println("请输入第二个整数：");
        int b = sc.nextInt();
        System.out.println("请输入运算符：");
        String ch = sc.next();

        //3 使用switch语句判断运算符
        switch (ch) {
            //4 根据不同的运算符执行对应的操作并打印结果
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            case "*":
                System.out.println(a * b);
                break;
            case "/":
                System.out.println(a * 1.0 / b);
                break;
            default:
                System.out.println("运算符输入错误！");
        }


    }
}
