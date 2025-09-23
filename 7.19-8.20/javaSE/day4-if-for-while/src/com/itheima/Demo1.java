package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 上午10:00
 */
/*
    if分支：根据条件执行对应的代码
    语法：
        单分支：
            if(条件){
                语句体
            }
            执行流程：首先判断条件的结果，如果为true执行语句体，为false就不执行语句体。
            注意1：if(条件）{}，()后不能跟","否则{}中的代码将不受if的控制了。
            注意2：if语句中,如果大括号控制的只有一行代码，则大括号可以省略不写.
        双分支：
            if(条件){
                语句体1
            }else{
                语句体2
            }
            执行流程：首先判断条件的结果，如果为true执行语句体1，为false就执行语句体2。
        多分支：
            if(条件1){
                语句体1
            }else if(条件2){
                语句体2
            }
            ...  //else if可以有多个
            else{
                语句体n
            }

           执行流程：
             1、先判断条件1的值，如果为true则执行语句体1，分支结束；如果为false则判断条件2的值
             2、如果条件2值为true就执行语句体2，分支结束；如果为false则判断条件3的值
             3、依次判断后面的每一个条件，条件为true执行对应的语句体
             4、如果没有任何条件为true，就执行else分支的语句体n。
 */
public class Demo1 {
    public static void main(String[] args) {

        System.out.println("开始执行程序");
        double temperature = 36.5;

        // 单分支结构 判断体温 if(条件){语句体}
        if(temperature > 37.5){
            System.out.println("体温不正常");
        }
        // 双分支结构 if(条件){语句体1}else{语句体2}
        if(temperature > 37.5){
            System.out.println("体温不正常");
        }else{
            System.out.println("体温正常");
        }
        System.out.println("程序执行结束");
    }
}
