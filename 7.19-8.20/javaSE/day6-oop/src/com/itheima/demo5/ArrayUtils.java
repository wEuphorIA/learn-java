package com.itheima.demo5;
/*
    操作数组的工具类
 */
public class ArrayUtils {
    private ArrayUtils(){}
    //提供静态方法，对整型数组求和
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    //提供静态方法，求整型数组最大值
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    //提供静态方法，求整型数组最小值
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    //提供静态方法，打印整型数组中的内容
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i]+"]");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}
