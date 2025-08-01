package exam;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 下午5:36 */
public class Test10 {
    //需求：
    //
    // 1.创建一个int类型的数组，元素为：10 20 30 40 50
    //
    // 2.遍历数组，打印每一个元素
    //
    // 3.获取数组中所有元素的和并打印
    //
    // 4.获取数组中元素的平均值并打印
    public static void main(String[] args) {
        // 1.创建一个int类型的数组，元素为：10 20 30 40 50
        int[] arr = {10, 20, 30, 40, 50};
        // 2.遍历数组，打印每一个元素
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // 3.获取数组中所有元素的和并打印
        System.out.println();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组中所有元素的和为" + sum);
        // 4.获取数组中元素的平均值并打印
        System.out.println("数组中元素的平均值为" +sum *1.0/ arr.length);
    }
}
