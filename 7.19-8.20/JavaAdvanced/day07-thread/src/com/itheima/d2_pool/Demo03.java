package com.itheima.d2_pool;

import java.util.concurrent.*;

/**
  拒绝策略：
       ThreadPoolExecutor.AbortPolicy：丢弃任务并抛出RejectedExecutionException异常
       ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常
       ThreadPoolExecutor.DiscardOldestPolicy：抛弃队列中等待最久的任务 然后把当前任务加入队列中
       ThreadPoolExecutor.CallerRunsPolicy：由主线程负责调用任务的run()方法从而绕过线程池直接执行
 */
public class Demo03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        MyCallable callable1 = new MyCallable(1);
        MyCallable callable2 = new MyCallable(5);
        MyCallable callable3 = new MyCallable(10);
        MyCallable callable4 = new MyCallable(100);

        Future<String> submit1 = poolExecutor.submit(callable1);
        Future<String> submit2 = poolExecutor.submit(callable2);
        Future<String> submit3 = poolExecutor.submit(callable3);
        Future<String> submit4 = poolExecutor.submit(callable4);

        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());
        System.out.println(submit4.get());

        poolExecutor.shutdown();
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
