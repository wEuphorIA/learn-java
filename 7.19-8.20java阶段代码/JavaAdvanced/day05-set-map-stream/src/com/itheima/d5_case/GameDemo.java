package com.itheima.d5_case;
/*
    目标：斗地主游戏的案例开发。
    业务需求分析:
        业务: 总共有54张牌。
        点数: "3","4","5","6","7","8","9","10","J","Q","K","A","2"
        花色: "♠", "♥", "♣", "♦"
        大小王: "👲" , "🃏"
        点数分别要组合4种花色，大小王各一张。
        斗地主：发出51张牌，剩下3张作为底牌。
 */
public class GameDemo {
    public static void main(String[] args) {
        Room room = new Room();
        room.start();
    }
}










