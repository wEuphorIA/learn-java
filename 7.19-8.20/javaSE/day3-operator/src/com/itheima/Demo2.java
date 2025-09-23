package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 上午10:20
 */
/*
    需求：有一个三位数(153)，请计算个位、十位、百位数字之和并打印在控制台。
    求个位、十位、百位、千位...数字规则：
        个位：数值 % 10
        十位：数值 / 10 % 10
        百位：数值 / 100 % 10
        千位：数值 / 1000 %10;
        ...
 */
public class Demo2 {
    public static void main(String[] args) {

        int number = 153;
        int ge = number % 10;
        int shi = number /10 % 10;
        int bai = number / 100 ;

        System.out.println(ge + shi + bai);

    }
}
