package com.itheima.demo2;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 上午11:06
 */
public class Demo {
    public static void main(String[] args) {
        // 创建第一个对象
        Student s1 = new Student();
        s1.name = "播妞";
        s1.chinese = 100;
        s1.math = 100;
        s1.printTotal();
        s1.printAverage();

        // 创建第二个对象
        System.out.println("------------------");
        Student s2 = new Student();
        s2.name = "播仔";
        s2.chinese = 59;
        s2.math = 100;
        s2.printTotal();
        s2.printAverage();

    }
}
