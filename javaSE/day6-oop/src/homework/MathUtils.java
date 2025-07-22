package homework;

import java.util.Arrays;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 下午4:42
 */
public class MathUtils {

    // 私有构造器，禁止实例化
    private MathUtils() {
        System.out.println("不能实例化工具类");
    }

    //最大值
    public static int maxArray(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
    //最小值
    public static int minArray(int[] arr){
        Arrays.sort(arr);
        return arr[0];
    }
    //数组求和
    public static int sumArray(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    //数组平均值
    public static double avgArray(int[] arr){
        return sumArray(arr) * 1.0 /arr.length;
    }
}
