package com.itheima.d1_thread.d2_api;

/**
 目标：掌握线程常用构造器和方法的使用
 构造器：
 Thread(String name)：可以为当前线程指定名称
 Thread(Runnable target)：封装Runnable对象成为线程对象
 Thread(Runnable target,String name )：封装Runnable对象成为线程对象，并指定线程名称
 线程获取和设置线程名称：
 String getName()：获取当前线程的名称，默认线程名称是Thread-索引
 void setName(String name)：将此线程的名称更改为指定的名称，通过构造器也可以设置线程名称
 <p>
 获取当前线程对象：
 static Thread currentThread()：返回对当前正在执行的线程对象的引用
 */
public class Demo01 {
    public static void main(String[] args) {
        new MyThread("线程1").start();
        MyThread thread2 = new MyThread();
        thread2.setName("线程2");
        thread2.start();

        MyThread thread3 = new MyThread("线程3");
        thread3.start();

        for (int i = 0; i < 5; i++) {
            Thread.currentThread().setName("主线程");
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

