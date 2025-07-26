package exam;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午8:45
 */
public class Test1 {
    public static void main(String[] args) {
        // 1. 随机6个红球 1-35 一个蓝球 1-15
        Random random = new Random();
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (treeSet.size() < 6) {
            int num = random.nextInt(1, 35);
            treeSet.add(num);
        }
        System.out.println("红球：" + treeSet);
        int num = random.nextInt(1, 16);
        System.out.println("蓝球：" + num);

        //定义一个集合存储中奖的号码，在判断中了几个红球，几个蓝球
        Set<Integer> luckRed = new TreeSet<>();
        Collections.addAll(luckRed,10,12,30,16,7,17);
        int luckyBlue = 12;

        int redCount = 0;
        for (Integer red : treeSet) {
            if (luckRed.contains(red)) {
                redCount++;
            }
        }
        // 判断蓝球是否中奖
        System.out.println("用户中了" + (luckyBlue == num ? "1个蓝球" : "0个蓝球"));
        System.out.println("用户中了" + redCount + "个红球");
    }
}
