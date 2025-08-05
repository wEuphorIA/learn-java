package com.itheima.d3_demo;

import java.util.Scanner;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午4:08 */
public class CardOperator {
    Scanner scanner = new Scanner(System.in);
    //存钱
    public void saveMoney(Card card) {
        System.out.println("请输入要存的金额: ");
        double money = scanner.nextDouble();
        card.saveMoney(money);
    }

    //消费
    public void consume(Card card) {
        System.out.println("请输入要消费的金额: ");
        double money = scanner.nextDouble();
        card.consume(money);
    }


}
