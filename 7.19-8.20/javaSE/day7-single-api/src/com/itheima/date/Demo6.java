package com.itheima.date;

/**
 * Math工具类的使用
 */
public class Demo6 {
    public static void main(String[] args) {

        //static double ceil(double a) 向上取整。
        System.out.println("Math.ceil(-5.1) = " + Math.ceil(-5.1));
        System.out.println("Math.ceil(-5.1) = " + Math.ceil(6.1));

        //static double floor(double a) 向下取整。
        System.out.println("Math.floor(5.1) = " + Math.floor(5.1));
        System.out.println("Math.floor(-5.1) = " + Math.floor(-5.1));

        //static int max(int a, int b) 返回两个int中的较大值。也有重载的方法，参数为long、double、float类型。
        System.out.println("Math.max(10, 20) = " + Math.max(10, 20));

        //static int min(int a, int b) 返回两个 int中的较小值。 ，也有重载的方法，参数为long、double、float类型。
        System.out.println("Math.min(10, 20) = " + Math.min(10, 20));

        //static double random() 返回值为 double的正值，大于等于 0.0 ，小于 1.0 。
        System.out.println("Math.random() = " + Math.random());

        //static long round(double a) 四舍五入。
        System.out.println("Math.round(10.5) = " + Math.round(10.5));
    }
}
