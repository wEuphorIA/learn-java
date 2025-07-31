package com.itheima.d2_pool;

//目标：了解线程池的拒绝策略
public class Demo03 {
    public static void main(String[] args) {
        /**
         * 拒绝策略：
         *      ThreadPoolExecutor.AbortPolicy：丢弃任务并抛出RejectedExecutionException异常
         *      ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常
         *      ThreadPoolExecutor.DiscardOldestPolicy：抛弃队列中等待最久的任务 然后把当前任务加入队列中
         *      ThreadPoolExecutor.CallerRunsPolicy：由主线程负责调用任务的run()方法从而绕过线程池直接执行
         */
    }
}

