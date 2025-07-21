package com.itheima;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入小明左手中的纸牌：");
        int a = sc.nextInt();
        System.out.println("请输入小明右手中的纸牌：");
        int b = sc.nextInt();
        System.out.println("互换前小明手中的纸牌：");
        System.out.println("小明左手中的纸牌是：" + a);
        System.out.println("小明右手中的纸牌是：" + b);
        int c = a;
        a = b;
        b = c;
        System.out.println("互换后小明手中的纸牌：");
        System.out.println("小明左手中的纸牌是：" + a);
        System.out.println("小明右手中的纸牌是：" + b);


    }
}