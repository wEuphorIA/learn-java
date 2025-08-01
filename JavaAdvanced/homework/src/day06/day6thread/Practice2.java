package day6thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 下午8:31
 */
public class Practice2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3, // 核心线程数 (corePoolSize)
                6, // 最大线程数 (maximumPoolSize)
                5, // 临时线程存活时间 (keepAliveTime)
                TimeUnit.SECONDS, // 临时线程存活时间单位 (TimeUnit)
                new ArrayBlockingQueue<>(10), // 临时线程队列 (workQueue)
                Executors.defaultThreadFactory(), // 临时线程工厂 (threadFactory)
                new ThreadPoolExecutor.AbortPolicy() // 临时线程拒绝策略 (handler)
        );
        for (int i = 1; i <= 16; i++) {
            //在Java中，Lambda表达式或匿名内部类中使用外部变量时，该变量必须是 final 或 effectively final 的。所谓 effectively final 就是该变量在初始化后没有被修改过。
            int finalI=i;
            //使用线程池提交任务，并传入数字编号
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName() + "线程正在执行" + finalI + "号任务");
            });
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
    }
}
