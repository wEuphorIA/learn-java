package exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 下午4:36 */
public class Test5 {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(101) + 20; // [20, 120]
        }
        int asInt = Arrays.stream(arr).max().getAsInt();
        System.out.println("数组中最大的数是：" + asInt);

        //统计数组中出现次数最大的数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int maxCount = 0;
        int maxNum = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > maxCount) {
                maxCount = map.get(key);
                maxNum = key;
            }
        }
        System.out.println("数组中出现次数最大的数是：" + maxNum + "，出现了" + maxCount + "次");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int target = sc.nextInt();
        int count = 0;
        for (int num : arr) {
            if (num == target) count++;
        }
        System.out.println(target + "在数组中出现了" + count + "次");
    }
}
