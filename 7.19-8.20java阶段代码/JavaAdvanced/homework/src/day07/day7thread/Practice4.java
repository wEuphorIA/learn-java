package day07.day7thread;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/16 下午8:06 */
public class Practice4 {

    private static final List<String> prizes = Arrays.asList(
            "苹果手机", "华为手机", "三洋踏板摩托", "迪拜7日游", "苹果笔记本",
            "联想笔记本", "小米空气净化器", "格力空调", "海尔冰箱", "海信电视"
    );
    public static void main(String[] args) {
        // 1. 创建自定义线程工厂（设置线程名称）
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger groupNum = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "第" + groupNum.getAndIncrement() + "组");
            }
        };

        // 2. 创建线程池（固定2个线程）
        ExecutorService executor = Executors.newFixedThreadPool(2, threadFactory);

        // 3. 创建抽奖箱（线程安全的集合）
        List<String> lotteryBox = new CopyOnWriteArrayList<>(prizes);

        // 4. 提交抽奖任务（模拟10次抽奖）
        for (int i = 1; i <= 10; i++) {
            executor.submit(() -> {
                if (!lotteryBox.isEmpty()) {
                    // 随机抽取一个奖品
                    int index = new Random().nextInt(lotteryBox.size());
                    String prize = lotteryBox.remove(index);
                    System.out.println(Thread.currentThread().getName() + " 抽中了: " + prize);
                }
            });
        }

        // 5. 关闭线程池
        executor.shutdown();
    }
}
