package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午3:05
 */
/*
    while循环：控制一段代码重复执行多次
    语法：
        初始化语句①;
        while(循环条件②){
            循环体语句(要重复执行的代码)③;
            迭代语句④;
        }
        解释：
            初始化语句：定义循环变量。例如：int i = 0;
            循环条件：判断循环变量的值，满足条件就循环，不满足条件就结束循环。 例如：i<3;
            迭代语句：修改循环变量的值。例如：i++
            循环体语句：重复执行的代码
    流程总结：①②③④--->②③④--->②③④--->...--->②③④--->②的结果是false结束循环
 */
public class Demo10 {
    public static void main(String[] args) {

        // 1 初始化语句①;
        int i = 0;
        // 2 循环条件②
        while(i < 3){
            // 3 循环体语句(要重复执行的代码)③;
            System.out.println("hello world");
            // 4 迭代语句④;
            i++;
        }


    }
}
