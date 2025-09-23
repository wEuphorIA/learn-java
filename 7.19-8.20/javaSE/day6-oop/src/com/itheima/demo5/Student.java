package com.itheima.demo5;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午4:47
 */
public class Student {

    static String schoolName = "黑马程序员";

    int age ;


    public static void show() {

        System.out.println("静态方法被调用");
        System.out.println(schoolName);

        // 静态方法中只能访问静态的成员变量和成员方法。
        // System.out.println(age);
        // show1()
        // 实例方法中可以出现this关键字，静态方法中不可以出现this关键字的。
        // System.out.println(this);
    }

    public void show1() {
        // 实例方法中既可以访问静态成员，也可以访问非静态成员。
        System.out.println("非静态方法被调用");
        System.out.println(schoolName);
        System.out.println(age);
        show();
        // 实例方法中可以出现this关键字，静态方法中不可以出现this关键字的。
        System.out.println(this);
    }
}
