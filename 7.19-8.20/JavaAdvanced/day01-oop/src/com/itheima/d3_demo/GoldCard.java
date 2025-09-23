package com.itheima.d3_demo;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午3:23 */
public class GoldCard extends Card {
    public GoldCard(String cardId, String name, String phone, double balance) {
        super(cardId, name, phone, balance);

        if (balance < 5000) {
            System.out.println("办卡金额必须大于5000");
            throw new RuntimeException("办卡金额必须大于5000");
        } else {
            System.out.println("办卡成功！");
        }
    }

    @Override
    public void consume(double money) {
        double newMoney = money * 0.8;
        if (getBalance() >= newMoney) {
            setBalance(getBalance() - newMoney);
            System.out.println("使用金卡消费了" + money + "元，实际支付了" + newMoney + "元" + "，余额为：" + getBalance());
            if (money >= 200) {
                System.out.println("消费满200，赠送一张洗车券");
            }
        } else {
            System.out.println("余额不足！");
        }
    }
}
