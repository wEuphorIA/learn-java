package com.itheima.d1_thread.d1_new.demo2;

//目标：掌握第二种创建线程的方式-实现Runnable接口
public class Demo02 {
    public static void main(String[] args) {
        /**
         * Thread构造器：
         *      Thread(Runnable target)：封装Runnable对象成为线程对象
         * 优点：线程任务类只是实现接口，可以继续继承类和实现接口，扩展性强
         * 缺点：编程多一层对象包装，如果线程有执行结果是不可以直接返回的
         *
         * 需求：定义一个线程任务类，去实现Runnable接口，重写run方法
         */
    }
}
