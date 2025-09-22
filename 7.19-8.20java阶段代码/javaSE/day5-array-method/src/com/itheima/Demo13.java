package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午6:16
 */
/*
    方法重载：一个类中，出现多个方法名相同，但是形参列表不同的方法，那么这些方法就称为方法重载
    注意：
        1、形参列表不同指的是：形参的个数、类型、不同类型参数的顺序不同，和参数名无关。
        2、方法重载只要求方法名相同参数列表不同，和修饰符、返回值类型无关。
 */
public class Demo13 {
    //原始数据
    public static int sum(int a, int b) {
        return a + b;  //返回结果
    }
    //形参的个数不同
    public static int sum(int a, int b, int c) {
        return a + b + c;  //返回结果
    }
    //形参的类型不同
    public static double sum(double a, int b) {
        return a + b;  //返回结果
    }
    //不同类型参数的顺序
    public static double sum(int a, double b) {
        return a + b;  //返回结果
    }
    //和参数名无关
    /* public static int sum(int b, int a) {
        int rs = a + b;  //方法体代码(方法内要做的事);
        return rs;  //返回结果
    }*/
    //方法重载只要求方法名相同参数列表不同，和修饰符、返回值类型无关。
    /*public static double sum(int a, int b) {
        int rs = a + b;  //方法体代码(方法内要做的事);
        return rs;  //返回结果
    }*/

}
