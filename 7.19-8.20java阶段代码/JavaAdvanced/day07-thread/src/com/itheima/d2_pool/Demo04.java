package com.itheima.d2_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
  使用Executors工具类实现线程池
      newCachedThreadPool()：线程数量随着任务增加而增加，如果线程任务执行完毕且空闲了一段时间则会被回收掉
      newFixedThreadPool(int nThreads)：创建固定线程数量的线程池，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程替代它
      newSingleThreadExecutor()：创建只有一个线程的线程池对象，如果该线程出现异常而结束，那么线程池会补充一个新线程
      newScheduledThreadPool(int corePoolSize)：创建一个线程池，可以实现在给定的延迟后运行任务，或者定期执行任务
 */
public class Demo04 {
    public static void main(String[] args) {
        // 目标：通过线程池工具类：Executors，调用其静态方法直接得到线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutorService executorService = Executors.newCachedThreadPool();


        while (true){
            executorService.submit(new MyRunnable1());
        }
    }
}
class MyRunnable1 implements Runnable {
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
