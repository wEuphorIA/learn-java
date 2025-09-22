package day07.day7thread;

import java.util.*;


/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/16 下午8:13 */
public class Practice5 {
    public static final List<String> prizes = Arrays.asList(
            "苹果手机", "华为手机", "三洋踏板摩托", "迪拜7日游", "苹果笔记本",
            "联想笔记本", "小米空气净化器", "格力空调", "海尔冰箱", "海信电视"
    );

    public static void main(String[] args) {
        // 1. 创建抽奖箱（使用同步集合）
        List<String> lotteryBox = Collections.synchronizedList(new ArrayList<>(prizes));

        Thread thread1 = new Thread(() -> {
            drawPrize(lotteryBox, "第一组");
        },"第一组");
        Thread thread2 = new Thread(() -> {
            drawPrize(lotteryBox, "第组");
        },"第二组");

        thread1.start();
        thread2.start();
    }
    private static void drawPrize(List<String> box, String groupName) {
        Random random = new Random();
        while (!box.isEmpty()) {
            synchronized (box) {  // 加锁保证抽奖原子性
                if (!box.isEmpty()) {
                    int index = random.nextInt(box.size());
                    String prize = box.remove(index);
                    System.out.println(groupName + " 抽中了: " + prize);
                }
            }
            try {
                Thread.sleep(500); // 模拟抽奖间隔
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

