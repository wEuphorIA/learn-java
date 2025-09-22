package com.itheima.d1_thread.d3_safe;

/*
需求：
    某一趟火车还剩下100张票，现在有三个窗口同时卖票，请使用多线程实现各个窗口的卖票情况，要求剩余票数为0时就停止卖票。
分析：
    1 三个窗口同时卖票，可以使用三个线程来模拟这三个窗口。
    2 三个窗口共卖这100张票，相当于做同一个任务，因此需要一个Runnable任务对象。
    3 在任务对象中重写run方法，定义卖票逻辑，只有当剩余票数大于0才可以卖票。
    4 启动三个线程开始卖票，观察打印结果。
 */
public class Demo01 {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket,"窗口1").start();
        new Thread(sellTicket,"窗口2").start();
        new Thread(sellTicket,"窗口3").start();
    }
}
class SellTicket implements Runnable{


    private Integer ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("窗口" + Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                ticket--;
            }else {
                break;
            }
        }
    }
}
