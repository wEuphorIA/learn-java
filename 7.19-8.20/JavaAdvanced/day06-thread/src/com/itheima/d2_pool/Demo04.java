package com.itheima.d2_pool;

//目标：掌握使用使用Executors工具类实现线程池
public class Demo04 {
    public static void main(String[] args) {
        /**
         * newCachedThreadPool()：
         *      线程数量随着任务增加而增加，如果线程任务执行完毕且空闲了一段时间则会被回收掉
         * newFixedThreadPool(int nThreads)：
         *      创建固定线程数量的线程池，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程替代它
         * newSingleThreadExecutor()：
         *      创建只有一个线程的线程池对象，如果该线程出现异常而结束，那么线程池会补充一个新线程
         * newScheduledThreadPool(int corePoolSize)：
         *      创建一个线程池，可以实现在给定的延迟后运行任务，或者定期执行任务
         */
    }
}

