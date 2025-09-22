package com.itheima.d3_demo;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午4:07 */
public class SilverCard extends  Card{
    public SilverCard(String cardId, String name, String phone, double balance) {
        super(cardId, name, phone, balance);
        if (balance < 2000){
            System.out.println("办卡金额必须大于2000");
            throw new RuntimeException("办卡金额必须大于2000");
        }
    }

    @Override
    public void consume(double money) {
        double newMoney = money * 0.9;
        if (getBalance() >= newMoney){
            setBalance(getBalance() - newMoney);
            System.out.println("使用银卡消费了" + money + "元，实际支付了" + newMoney + "元" + "，余额为：" + getBalance());
        }else {
            System.out.println("余额不足！");
        }
    }
}
