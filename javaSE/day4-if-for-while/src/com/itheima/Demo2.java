package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 上午10:15
 */
/*
    需求：键盘录入考试成绩，根据成绩所在的区间，程序打印出不同的奖励机制
    实现步骤：
        //1 创建Scanner扫描器对象
        //2 提示并获取用户输入的成绩
        //3 使用if...else if...else 多分支结构判断成绩
        //4 打印不同的奖励
 */
public class Demo2 {
    public static void main(String[] args) {

        //1 创建Scanner扫描器对象
        Scanner sc = new Scanner(System.in);

        //2 提示并获取用户输入的成绩
        System.out.println("请输入考试成绩：");
        int score = sc.nextInt();

        //3 使用if...else if...else 多分支结构判断成绩
        if(score >= 95 && score <= 100){
            //4 打印不同的奖励
            System.out.println("奖励自行车一辆");
        }else if(score >= 90 && score <= 94){
            //4 打印不同的奖励
            System.out.println("奖励游乐园一日游");
        }else if(score >= 80 && score <= 89){
            //4 打印不同的奖励
            System.out.println("奖励变形金刚");
        }else{
            //4 打印不同的奖励
            System.out.println("揍一顿");
        }
    }
}
