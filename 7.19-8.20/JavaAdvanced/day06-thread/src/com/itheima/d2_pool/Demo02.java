package com.itheima.d2_pool;

//目标：掌握线程池处理Runnable任务和Callable任务
public class Demo02 {
    public static void main(String[] args){
        /**
         * ExecutorService的常用api：
         *      execute(Runnable runnable)：执行任务/命令，没有返回值，一般用来执行 Runnable 任务
         *      Future<T> submit(Callable<T> task)：执行任务，返回未来任务对象获取线程结果，一般拿来执行Callable任务
         *      shutdown()：等任务执行完毕后关闭线程池
         *      shutdownNow()：立刻关闭，停止正在执行的任务，并返回队列中未执行的任务
         */
    }
}