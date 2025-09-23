package homework;

import java.util.Arrays;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 上午10:44
 */
public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr = {100,50,90,60,80,70};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组中元素的平均值" + sum/arr.length);

        sum = 0;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length -1; i++){
            sum += arr[i];
        }
        System.out.println("数组中元素去掉一个最大值和一个最小值的平均值" + sum/(arr.length - 2));

        System.out.println("数组中元素大于平均值的元素");
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > sum/(arr.length - 2)) {
                System.out.print(arr[i] + "   ");
            }
        }
    }
}
