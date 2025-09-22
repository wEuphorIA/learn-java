package com.itheima.d2_recursion;
/*
    猴子第一天摘下若干桃子，当即吃了一半，觉得好不过瘾，于是又多吃了一个
    第二天又吃了前天剩余桃子数量的一半，觉得好不过瘾，于是又多吃了一个
    以后每天都是吃前天剩余桃子数量的一半，觉得好不过瘾，又多吃了一个
    等到第10天的时候发现桃子只有1个了。
    需求：请问猴子第一天摘了多少个桃子？
 */
public class Demo3 {
    public static void main(String[] args) {
        // 目标：递归解决猴子吃桃问题。
        // 公式：
        // 终结点： f(10) = 1
        // 递归的方向:
        System.out.println(f(1));

        System.out.println(f1(1));
    }
    private static int f(int n){
        if(n == 10){
            return 1;
        }
        return (f(n + 1) + 1)*2;
    }

    private static int f1(int n){
        int sum = 1;
        for (int i = 10; i > n; i--){
            sum = (sum + 1)*2;
        }
        return sum;
    }


}
