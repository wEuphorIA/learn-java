package day05.stream;

import java.util.Random;
import java.util.TreeSet;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/12 下午7:59 */
public class Practice2 {
    public static void main(String[] args) {
        Random random = new Random();

        TreeSet<Integer> set = new TreeSet<>();
        while (set.size() < 6){
            int red = random.nextInt(1, 34);
            set.add(red);
        }
        int blue = random.nextInt(1, 17);
        System.out.print("红球：");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println("蓝球：" + blue);
    }
}
