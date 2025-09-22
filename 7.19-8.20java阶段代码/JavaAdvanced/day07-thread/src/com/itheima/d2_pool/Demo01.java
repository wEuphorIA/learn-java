package com.itheima.d2_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
    目标：掌握线程池的创建
     ThreadPoolExecutor构造器参数：
         核心线程数，
         最大线程数，
         临时线程最大存活时间，
         存活时间的单位，
         任务队列（等待的任务），
         创建线程的线程工厂（Executors.defaultThreadFactory()），
         拒绝策略（默认策略：new ThreadPoolExecutor.AbortPolicy()）
 */

/**
 拒绝策略：
 ThreadPoolExecutor.AbortPolicy：丢弃任务并抛出RejectedExecutionException异常
 ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常
 ThreadPoolExecutor.DiscardOldestPolicy：抛弃队列中等待最久的任务 然后把当前任务加入队列中
 ThreadPoolExecutor.CallerRunsPolicy：由主线程负责调用任务的run()方法从而绕过线程池直接执行
 */

/**
 目标：掌握线程池处理Runnable任务和Callable任务
 ExecutorService的常用api：
 execute(Runnable runnable)：执行任务/命令，没有返回值，一般用来执行 Runnable 任务
 Future<T> submit(Callable<T> task)：执行任务，返回未来任务对象获取线程结果，一般拿来执行Callable任务
 shutdown()：等任务执行完毕后关闭线程池
 shutdownNow()：立刻关闭，停止正在执行的任务，并返回队列中未执行的任务
 */
public class Demo01 {
    public static void main(String[] args){

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        MyRunnable1 myRunnable = new MyRunnable1();
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable);
        poolExecutor.execute(myRunnable); //创建一个临时线程 只有在核心线程和等待队列满了，最大线程还有空闲的时候创建临时线程
        poolExecutor.execute(myRunnable); //创建一个临时线程
        // poolExecutor.execute(myRunnable); //线程池中最大线程数量和任务队列中的都满了，执行拒绝策略
        // poolExecutor.shutdownNow();


    }
}

// 1、定义一个线程任务类实现Runnable接口
class MyRunnable implements Runnable {
    // 2、重写run方法，设置线程任务
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "输出：" + i);
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

