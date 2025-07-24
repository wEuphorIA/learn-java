package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 上午11:08
 */
public class Demo4 {
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
            case "周三":
            case "周四":
                System.out.println("请求大牛程序员帮忙");
                break;
            case "周五":
                System.out.println("自己整理代码");
                break;
            case "周六":
            case "周日":
                System.out.println("打游戏");
                break;
            default:
                System.out.println("输入的数字有误");
        }
    }
}
