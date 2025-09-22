package com.itheima.d3_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午3:09 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String cardId; //卡号
    private String name; //姓名
    private String phone; //手机号
    private double balance;//账户余额


    //存款
    public void saveMoney(double money){
        balance += money;
    }

    //消费
    public void consume(double money){
        balance -= money;
    }
}
