package day07.day7thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/16 下午7:58 */
public class Practice3 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,//核心线程数
                2,//最大线程数
                0L,//临时线程存活时间
                TimeUnit.SECONDS,//临时线程存活单位
                new LinkedBlockingDeque<>(10),//任务队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        MyRunable2 myRunable2 = new MyRunable2();
        for (int i = 0; i < 2; i++) {
            pool.execute(myRunable2);
        }
        pool.shutdown();
    }
}

class MyRunable2  implements Runnable {
    int count = 1000;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            count = count + 100;
            System.out.println(Thread.currentThread().getName() + " 存入100元后,账户的余额是: " + (count));
        }
    }
}