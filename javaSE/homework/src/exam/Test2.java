package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午9:11
 */
public class Test2 {
    public static void main(String[] args) {
        // 生成100个不重复的1-200之间的随机数，
        Random random = new Random();
        ArrayList<Integer> integers = new ArrayList<>();
        while (integers.size() < 100) {
            int num = random.nextInt(1, 200);
            if (!integers.contains(num)) {
                integers.add(num);
            }
        }

        System.out.println("囚犯原始编号：" + integers);

        // 记录初始位置（1~100）
        List<Integer> initialPositions = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            initialPositions.add(i);
        }

        // 模拟淘汰过程
        List<Integer> currentIds = new ArrayList<>(integers);
        List<Integer> currentPositions = new ArrayList<>(initialPositions);

        while (currentIds.size() > 1) {
            List<Integer> nextIds = new ArrayList<>();
            List<Integer> nextPositions = new ArrayList<>();
            for (int i = 0; i < currentIds.size(); i++) {
                if (i % 2 == 1) {
                    nextIds.add(currentIds.get(i));
                    nextPositions.add(currentPositions.get(i));
                }
            }
            currentIds = nextIds;
            currentPositions = nextPositions;
        }

        System.out.println("幸存者编号: " + currentIds.get(0));
        System.out.println("幸存者初始位置: " + currentPositions.get(0));
    }
}
