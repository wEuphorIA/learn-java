package com.itheima;

import java.util.Arrays;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 上午10:14
 */
/*
    数组：是一种数据结构，可以看成是一个容器，用来保存一批同类型数据。
    初始化方式：
        方式一：静态初始化：创建数组的同时向数组中存储。（立马存值）
            写法一：数据类型[] 数组名 = new 数据类型[]{值1,值2,值3,值4,值5};
            写法二：数据类型[] 数组名 = {值1,值2,值3,值4,值5};  【推荐】
        方式二：动态初始化：定义数组时先不存入具体的值，只确定数组的类型和数组的长度，JVM会根据数组类型向数组中存入默认值。
            数据类型[] 数组名 = new 数据类型[长度]
            注意：数据类型[] 数组名 = new 数据类型[长度]{值1,值2,值3,值4,值5};是错误的。

            默认值：
                byte、short、int、long类型数组默认值：0
                char类型数组默认值：\u0000
                float、double类型数组默认值：0.0
                boolean类型数组默认值：false
                引用类型数组默认值：null
 */
public class Demo1 {
    public static void main(String[] args) {

        // 静态初始化：创建数组的同时向数组中存储。
        // 数据类型[] 数组名 = new 数据类型[]{值1,值2,值3,值4,值5};
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));

        // 数据类型[] 数组名 = {值1,值2,值3,值4,值5};  【推荐】
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr1));

        // 动态初始化：定义数组时先不存入具体的值，只确定数组的类型和数组的长度，JVM会根据数组类型向数组中存入默认值。
        // 数据类型[] 数组名 = new 数据类型[长度]
        int[] arr2 = new int[5];

        // byte、short、int、long类型数组默认值：0
        System.out.println(Arrays.toString(arr2));

        // char类型数组默认值：\u0000
        char[] arr3 = new char[5];
        System.out.println(Arrays.toString(arr3));

        // float、double类型数组默认值：0.0
        double[] arr4 = new double[5];
        System.out.println(Arrays.toString(arr4));

        // boolean类型数组默认值：false
        boolean[] arr5 = new boolean[5];
        System.out.println(Arrays.toString(arr5));

        // 引用类型数组默认值：null
        String[] arr6 = new String[5];
        System.out.println(Arrays.toString(arr6));

        Object[] arr7 = {Arrays.toString(arr1), arr2, arr3, arr4, arr5, arr6};
        System.out.println(Arrays.toString(arr7));

    }
}
