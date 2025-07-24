package com.itheima;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午5:30
 */
/*
    需求：随机生成一个1-100(不包括)之间的整数，提示用户猜测，猜大提示过大，猜小提示过小，直到猜中结束游戏。
    实现步骤：
        //1 创建Random随机数和Scanner扫描器对象
        //2 随机生成一个1-100(不包括)之间的数据。
        //3 定义一个死循环让用户可以一直猜测。
        //4 在死循环里，提示并获取用户猜的数字，
        //5 将猜的数字和随机数比较，猜大提示过大，猜小提示过小，猜中则结束游戏。
 */
public class Demo20 {
    public static void main(String[] args) {
        System.out.println("猜数字小游戏");
        Random random = new Random();
        int num = random.nextInt(1, 101);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入数字");
            int num1 = scanner.nextInt();
            if (num1 > num) {
                System.out.println("猜大了");
            } else if (num1 < num){
                System.out.println("猜小了");
            }else {
                System.out.println("猜对了,正确的随机数为" + num);
                break;
            }
        }
    }
}
