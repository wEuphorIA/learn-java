package com.itheima.d1_thread.d2_api;

/**
    目标：掌握线程休眠的方式使用
        public final void join()...	让调用当前这个方法的线程先执行完！
    需求：在主线程中每隔1秒钟打印一次"奥里给！！！"，共打印10次。
 */
public class Demo03 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyRunable1(),"子线程");
        thread.start();

        for (int i = 0; i < 10; i++) {
            if (i == 1){
                thread.join();
            }
            System.out.println(Thread.currentThread().getName() + "奥里给！！！");
        }

    }
}
class MyRunable1 implements Runnable{

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