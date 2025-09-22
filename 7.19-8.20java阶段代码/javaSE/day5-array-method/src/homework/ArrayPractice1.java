package homework;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 上午11:08
 */
public class ArrayPractice1 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random Random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Random.nextInt(100,1000) ;
        }
        System.out.println("原数组为" + Arrays.toString(arr));

        System.out.print("数组中回文数元素为：");
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int a = temp / 100;
            int c = temp % 10;
            if (a == c) {
                System.out.print(temp + "  ");
            }
        }
    }
}
