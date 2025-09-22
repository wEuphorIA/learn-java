package com.itheima.d1_thread.d1_new.demo3;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 目标：掌握线程的第三种创建方式-Callable、FutureTask接口实现
 FutureTask的API：
 FutureTask<>(Callable call)：把Callable对象封装成FutureTask对象
 V get()：获取线程执行call方法返回的结果
 多线程的第三种创建方式：利用Callable接口、FutureTask类来实现。
 实现步骤
 1 创建任务对象
 定义一个类实现Callable接口，重写call方法，封装要做的事情，和要返回的数据。
 把Callable类型的对象封装成FutureTask（线程任务对象）。
 2 把线程任务对象交给Thread对象。
 3 调用Thread对象的start方法启动线程。
 4 线程执行完毕后、通过FutureTask对象的的get方法去获取线程任务执行的结果。
 <p>
 方式三优缺点：
 优点：线程任务类只是实现接口，可以继续继承类和实现接口，扩展性强；可以在线程执行完毕后去获取线程执行的结果。
 缺点：编码复杂一点。
 */
public class Demo03 {
    public static void main(String[] args) {

        MyCallable myCallable = new MyCallable(10);
        //FutureTask<>(Callable call)：把Callable对象封装成FutureTask对象
        FutureTask<String> task = new FutureTask<>(myCallable);
        new Thread(task).start();


        try {
            //V get()：获取线程执行call方法返回的结果
            System.out.println(task.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MyCallable myCallable1 = new MyCallable(100);
        FutureTask<String> task1 = new FutureTask<>(myCallable1);
        new Thread(task1).start();


        try {
            System.out.println(task1.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}

class MyCallable implements Callable<String> {

    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "1-" + n + "和为" + sum;
    }
}
