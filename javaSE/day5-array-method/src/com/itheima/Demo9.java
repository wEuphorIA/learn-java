package com.itheima;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午4:30
 */
/*
    需求：定义方法，生成n个1~100(包括1不包括100)之间的随机奇数保存到数组中并返回。
    分析：
        参数列表：(int n)
        返回值：整型数组 int[]
        方法内逻辑：
            //1 创建长度为n的数组。
            //2 创建Random随机数对象。
            //3 遍历数组，使用random生成1~100之间的随机数。
            //4 判断随机数是不是奇数，如果是就保存到数组中，如果不是就重新循环随机一个。
            //5 返回数组。
 */
public class Demo9 {
    public static void main(String[] args) {
        int[] arr = createArray(5);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] createArray(int n) {
        //1 创建长度为n的数组。
        int[] arr = new int[n];
        //2 创建Random随机数对象。
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {

            //3 遍历数组，使用random生成1~100之间的随机数。
            int number = random.nextInt(1, 100);

            //4 判断随机数是不是奇数，如果是就保存到数组中，如果不是就重新循环随机一个。
            if (number % 2 != 0){
                arr[i] = number;
            }else {
                i--;
            }
        }
        //5 返回数组。
        return arr;
    }
}
