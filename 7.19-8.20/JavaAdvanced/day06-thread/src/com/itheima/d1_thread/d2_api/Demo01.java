package com.itheima.d1_thread.d2_api;

//目标：掌握线程常用构造器和方法的使用
public class Demo01 {
    public static void main(String[] args) {
        /**
         *
         * 构造器：
         *      Thread(String name)：可以为当前线程指定名称
         *      Thread(Runnable target)：封装Runnable对象成为线程对象
         *      Thread(Runnable target,String name )：封装Runnable对象成为线程对象，并指定线程名称
         * 线程获取和设置线程名称：
         *      String getName()：获取当前线程的名称，默认线程名称是Thread-索引
         *      void setName(String name)：将此线程的名称更改为指定的名称，通过构造器也可以设置线程名称
         *
         * 获取当前线程对象：
         *      static Thread currentThread()：返回对当前正在执行的线程对象的引用
         */
    }
}

