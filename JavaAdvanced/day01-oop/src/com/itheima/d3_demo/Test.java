package com.itheima.d3_demo;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午4:10 */
public class Test {
    public static void main(String[] args) {
        CardOperator co = new CardOperator();

        GoldCard goldCard = new GoldCard("G001", "欧巴", "13888888888", 5000.0);
        co.saveMoney(goldCard);
        co.consume(goldCard);
        Card silverCard = new SilverCard("S001", "小欧", "13888888888", 5000.0);
        co.saveMoney(silverCard);
        co.consume(silverCard);
    }
}
