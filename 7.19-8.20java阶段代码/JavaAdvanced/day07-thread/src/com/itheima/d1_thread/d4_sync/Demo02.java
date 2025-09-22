package com.itheima.d1_thread.d4_sync;

/**
   目标：掌握使用同步方法的方式给线程代码上锁
   同步方法其实底层也是有隐式锁对象的，只是锁的范围是整个方法代码

   格式：
        修饰符 synchronized 返回值类型 方法名称(形参列表) {
                操作共享资源的代码
        }

   如果方法是实例方法：同步方法默认用this作为的锁对象
   如果方法是静态方法：同步方法默认用类名.class作为的锁对象

   需求：使用同步方法改进火车站售票案例
 */
public class Demo02 {
    public static void main(String[] args) {

        SellTicket2 SellTicket2 = new SellTicket2();
        new Thread(SellTicket2, "窗口1").start();
        new Thread(SellTicket2, "窗口2").start();
        new Thread(SellTicket2, "窗口3").start();
    }
}

class SellTicket2 implements Runnable {


    private Integer ticket = 100;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (sell()) break;

        }
    }

    private synchronized boolean sell() {
        if (ticket > 0) {

            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
            ticket--;
        } else {
            return true;
        }
        return false;
    }
}
