package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午3:12
 */

/*
    需求：假设你在银行投资了100000元，银行给出的年化利率是1.7%，问多少年后能实现本金翻倍？
    实现步骤：
        1 定义变量本金、年化利率、年数。
        2 使用while循环控制年数增长，每循环一次本金=本金+本金*年利率（本金+=本金*年利率）。
        3 每循环一次，年数+1，直到本金翻倍。
        4 循环结束后打印年数。
 */
public class Demo13 {
    public static void main(String[] args) {
        double money = 100000;//本金
        double yearRate = 0.017;//年利率
        int year = 0;
        while ( money < 200000){
            money +=  (money *yearRate);
            year++;
        }
        System.out.println("money = " + money);
        System.out.println("year = " + year);
    }
}
