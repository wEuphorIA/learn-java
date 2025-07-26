package com.itheima;



/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午4:52
 */
/*
    需求：求数组中的最大值
    分析：
        参数列表：(int[] arr)
        返回值：int
        方法内逻辑：
            //1 定义一个变量max用于记录最大值，初始值为数组中索引0处的元素。
            //2 从1索引处遍历数组，将每个数和max比较。
            //3 如果比max大，就替换max原来的值。
            //4 循环结束之后返回max值即为最大值
 */
public class Demo10 {
    public static void main(String[] args) {
        int[] arr = {23, 73, 62, 37, 92, 188, 28, 21, 102, 29, 83, 79};


        int max = getMax(arr);
        System.out.println("max = " + max);

        // 求最小值
        int min = getMin(arr);
        System.out.println("min = " + min);

    }

    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
