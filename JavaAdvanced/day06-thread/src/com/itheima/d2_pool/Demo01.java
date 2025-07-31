package com.itheima.d2_pool;

import java.util.concurrent.ExecutionException;

//目标：掌握线程池的创建
public class Demo01 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * ThreadPoolExecutor构造器参数：
         *      核心线程数，
         *      最大线程数，
         *      临时线程最大存活时间，
         *      存活时间的单位，
         *      任务队列（等待的任务），
         *      创建线程的线程工厂（Executors.defaultThreadFactory()），
         *      拒绝策略（默认策略：new ThreadPoolExecutor.AbortPolicy()）
         */

    }
}

