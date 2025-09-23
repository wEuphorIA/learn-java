package day07.day7thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/16 下午7:46 */
public class Practice2 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数
                6,//最大线程数
                5L,//临时线程存活时间
                TimeUnit.SECONDS,//临时线程存活单位
                new LinkedBlockingDeque<>(10),//任务队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        MyRunable1 myRunable1 = new MyRunable1();
        for (int i = 0; i < 16; i++) {
            pool.execute(myRunable1);
        }
        pool.shutdown();
    }
}
class MyRunable1 implements  Runnable{
    int i = 1;

    @Override
    public synchronized void run() {

        System.out.println("第" + i + "个任务" + " | 执行线程: " + Thread.currentThread().getName());
        i++;
    }
}