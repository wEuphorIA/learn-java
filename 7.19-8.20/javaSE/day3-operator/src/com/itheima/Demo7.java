package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午3:16
 */
/*
    逻辑运算符：把多个条件放在一起运算，最终返回布尔类型的值：true、false。
        &  逻辑与  条件1&条件2  当两个条件都为true时，结果为true，有一个是false结果就是false。
        |  逻辑或  条件1|条件2  当两个条件有一个为true时，结果为true，两个都是false结果就是false。
        !  逻辑非  !条件   表示取反，原始条件是true取反就是false，原始条件是false取反就是true。
        ^  逻辑异或  条件1^条件2    条件1和条件2不同为true，相同为false。

        &&  短路与    条件1 && 条件2    判断结果和&是一样的，特点：左边为false，右边不执行。【常用】
        ||  短路或    条件1 || 条件2    判断结果和|是一样的，特点：左边为true，右边不执行。【常用】
 */
public class Demo7 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        System.out.println(a > 15 & b > 15); // false & true = false
        System.out.println(a > 15 | b > 15); // false | true = true
        System.out.println(!(a > 15));       // !true = false
        System.out.println(a > 15 ^ b > 15); // false ^ true = true

        System.out.println(a > 15 && a++ > 15); //a=10不执行a++
        System.out.println(a);

        System.out.println(a < 15 || a++ > 15);//a=10不执行a++
        System.out.println(a);
    }
}
