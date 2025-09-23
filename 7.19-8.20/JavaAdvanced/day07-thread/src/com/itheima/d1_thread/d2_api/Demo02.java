package com.itheima.d1_thread.d2_api;

/**
    目标：掌握线程休眠的方式使用
        void sleep(long time)：让当前线程休眠指定的时间后再继续执行，单位为毫秒
    需求：在主线程中每隔1秒钟打印一次"奥里给！！！"，共打印10次。
 */
public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
    new Thread(new MyRunable(),"线程1").start();

    }
}
class MyRunable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("奥里给！！！");
        }
    }
}