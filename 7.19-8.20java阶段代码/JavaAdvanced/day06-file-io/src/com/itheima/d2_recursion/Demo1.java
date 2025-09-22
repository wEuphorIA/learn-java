package com.itheima.d2_recursion;

/**
 * 目标：认识一下递归的形式。
 */
public class Demo1 {
    public static void main(String[] args) {
        // 目标：认识递归的形式。
        printA();
        // printB();
    }
    // 直接递归
    public static void printA() {
        System.out.println("===A执行了===");
        printA(); // 直接递归：自己调用自己  .  递归可能出现死循环，导致出现栈内存溢出现象。StackOverflowError

    }

    // 间接递归
    public static void printB() {
        System.out.println("===B执行了===");
        printC();
    }
    public static void printC() {
        System.out.println("===C执行了===");
        printB();
    }
}
