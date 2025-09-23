package com.itheima.d1_network.demo9;

import java.math.BigDecimal;

public class Demo3BigDecimal {
    public static void main(String[] args) {
        //掌握BigDecimal的使用
        //method1();
        method2();
    }

    //演示使用浮点型直接运算时的问题
    private static void method1() {
        System.out.println(0.1 + 0.2);
        System.out.println(1.015 * 100);
    }

    //演示BigDecimal的使用
    private static void method2() {
        //1. 创建BigDecimal对象
        /*BigDecimal b1 = new BigDecimal(0.1); //不推荐
        BigDecimal b2 = new BigDecimal(0.2);//不推荐
        BigDecimal addResult = b1.add(b2);
        System.out.println(addResult.doubleValue());*/


        BigDecimal b1 = BigDecimal.valueOf(0.1);
        BigDecimal b2 = BigDecimal.valueOf(0.2);
        BigDecimal addResult = b1.add(b2);
        System.out.println(addResult.doubleValue());

        //2. 进行运算
        System.out.println(b1.subtract(b2).doubleValue());
        System.out.println(b1.multiply(b2).doubleValue());

        BigDecimal b3 = BigDecimal.valueOf(0.1);
        BigDecimal b4 = BigDecimal.valueOf(0.3);
        BigDecimal divideResult = b3.divide(b4, 2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(divideResult.doubleValue());

    }
}
