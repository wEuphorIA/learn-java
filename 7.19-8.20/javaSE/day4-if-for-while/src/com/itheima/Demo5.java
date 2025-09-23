package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 上午11:27
 */
/*
    for循环：控制一段代码重复执行多次
    语法：
        for(初始化语句①;循环条件②;迭代语句)④{
            循环体语句(要重复执行的代码)③
        }
        解释：
            初始化语句：定义循环变量。例如：int i = 0;
            循环条件：判断循环变量的值，满足条件就循环，不满足条件就结束循环。 例如：i<3;
            迭代语句：修改循环变量的值。例如：i++
            循环体语句：重复执行的代码
    快捷键：
        正向循环（i的值从小到大）：循环次数.fori+回车
        倒着循环（i的值从大到小）：循环次数.forr+回车
    流程总结：①②③④--->②③④--->②③④--->...--->②③④--->②的结果是false结束循环
 */
public class Demo5 {
    public static void main(String[] args) {

        // 正向循环（i的值从小到大）：循环次数.fori+回车
        for (int i = 0; i < 3; i++) {
            System.out.println("hello world");
        }

        // 倒着循环（i的值从大到小）：循环次数.forr+回车
        for (int i = 3; i > 0; i--) {
            System.out.println("hello");
        }
    }
}
