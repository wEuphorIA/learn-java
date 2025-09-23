package com.itheima.d1_thread.d4_sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 目标：掌握Lock锁给线程代码上锁
 Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来构建Lock锁对象
 void lock()：获得锁
 void unlock()：释放锁
 需求：使用lock锁改进火车站售票案例
 */
public class Demo03 {
    public static void main(String[] args) {
        SellTicket3 sellTicket3 = new SellTicket3();
        new Thread(sellTicket3, "窗口1").start();
        new Thread(sellTicket3, "窗口2").start();
        new Thread(sellTicket3, "窗口3").start();
    }
}

class SellTicket3 implements Runnable {

    private final Lock lock = new ReentrantLock();

    private Integer ticket = 100;


    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println("窗口" + Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
