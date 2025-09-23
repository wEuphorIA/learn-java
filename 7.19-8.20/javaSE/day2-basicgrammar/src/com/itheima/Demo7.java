package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午4:16
 */
/*
    强制类型转换：类型范围大的变量/值 不能 直接赋值给类型范围小的变量报错，需要强制类型转。
    语法：
        小范围类型 变量 = (小范围类型) 大类型范围的变量/值;
    注意1：强制类型转换可能造成数据(丢失)溢出；
    注意2：浮点型强转成整型，直接丢掉小数部分，保留整数部分返回
 */
public class Demo7 {
    public static void main(String[] args) {

        //强制类型转换：类型范围大的变量/值,不能直接赋值给类型范围小的变量报错，需要强制类型转。
        int a = 10;
        byte b = (byte)a;
        System.out.println(b);

        //注意1：强制类型转换可能造成数据(丢失)溢出；
        int c = 128;
        byte d = (byte)c;
        System.out.println(d);

        //注意2：浮点型强转成整型，直接丢掉小数部分，保留整数部分返回
        double e = 10.99;
        int f = (int)e;
        System.out.println(f);
    }
}
