package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 上午10:49
 */
/*
    switch分支结构：是通过比较值是否相等，来决定执行哪条分支。
    语法：
        switch(表达式){  //这个表达式可以是一个变量，也可以是一个做运算的式子(一定要有结果)
            case 值1:
                语句1;
                break;
            case 值2:
                语句2;
                break;
            ...
            default:
                语句n;
        }
    执行流程：
        1、先执行表达式的结果，再拿着这个结果去与case后的值进行匹配。
        2、与哪个case后的值相等就执行哪个case块的代码，遇到break就跳出switch分支。
        3、如果表达式的结果与所有case后的值都不相等，则执行default块的代码。
 */
public class Demo3 {
    public static void main(String[] args) {

        // 需求：根据用户输入的数字，打印对应的星期几
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入周几：");
        String week = scanner.next();
        switch (week){
            case "周一":
                System.out.println("埋头苦干，解决bug");
                break;
            case "周二":
                System.out.println("请求大牛程序员帮忙");
                break;
            case "周三":
                System.out.println("吃烧烤");
                break;
            case "周四":
                System.out.println("帮助新来的女程序员解决bug");
                break;
            case "周五":
                System.out.println("今晚吃鸡");
                break;
            case "周六":
                System.out.println("与王婆介绍的对象相亲");
                break;
            case "周日":
                System.out.println("郁郁寡欢，准备上班");
                break;
            default:
                System.out.println("输入的数字有误");
        }
    }
}
