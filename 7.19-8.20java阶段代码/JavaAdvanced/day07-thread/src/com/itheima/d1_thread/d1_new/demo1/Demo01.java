package com.itheima.d1_thread.d1_new.demo1;

/**
    第一种线程创建的方式-继承Thread
        Java通过java.lang.Thread类来代表线程的
    优点：编码简单
    缺点：线程类已经继承Thread，无法继承其他类，不利于扩展
    需求：自定义一个线程类MyThread，重写run方法。开启线程使用
 */
public class Demo01 {
    public static void main(String[] args) {
        new MyThread().start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程" + i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100;i++) {
            System.out.println("子线程" + i);
        }
    }
}