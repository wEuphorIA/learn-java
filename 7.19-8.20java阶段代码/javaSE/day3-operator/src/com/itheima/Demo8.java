package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午4:03
 */
/*
    三元运算符：根据条件返回一个值。
        语法： 关系表达式(条件)? 值1 : 值2
        常见用法：数据类型 变量 =  关系表达式(条件)? 值1 : 值2
        执行流程：判断关系表达式的结果，如果为true就将值1赋值给等号左边的变量，如果为false就将值2赋值给等号左边的变量。。
 */
public class Demo8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");

        double score = scanner.nextDouble();

        System.out.println(score >= 60 ? "成绩合格" : "成绩不合格");
    }
}
