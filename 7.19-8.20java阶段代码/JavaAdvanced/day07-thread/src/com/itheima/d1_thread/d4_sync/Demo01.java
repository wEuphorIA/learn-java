package com.itheima.d1_thread.d4_sync;

/**
 目标：掌握同步代码块给线程代码加锁
 作用：把出现线程安全问题的核心代码给上锁
 格式：
 synchronized(同步锁对象){
 操作共享资源的代码
 }
 <p>
 锁对象要求：锁对象只要对于当前同时执行的线程来说是同一个对象即可
 原理：每次只能一个线程进入，执行完毕后自动解锁，其他线程才可以进来执行
 <p>
 需求：使用同步代码块改进火车站售票案例
 */
public class Demo01 {
    public static void main(String[] args) {

        SellTicket SellTicket = new SellTicket();
        new Thread(SellTicket, "窗口1").start();
        new Thread(SellTicket, "窗口2").start();
        new Thread(SellTicket, "窗口3").start();
    }
}

class SellTicket implements Runnable {


    private Integer ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (this) {
                if (ticket > 0) {

                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
