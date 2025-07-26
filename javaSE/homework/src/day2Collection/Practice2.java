package day2Collection;

import java.util.Random;
import java.util.TreeSet;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午8:33
 */
public class Practice2 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        Random random = new Random();
        while (set.size() < 6) {
            int num = random.nextInt(1,34);
            set.add(num);
        }
        System.out.print("红球：");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        int num = random.nextInt(1,17);
        set.add( num);
        System.out.println("蓝球：" + num);

        System.out.println("双色球号码为：");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
    }
}
