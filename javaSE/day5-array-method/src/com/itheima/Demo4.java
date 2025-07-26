package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 上午11:32
 */
/*
    二维数组：数组中的每个元素都是一个一维数组，这个数组就是二维数组，
    初始化：
        静态初始化：
            写法一：数据类型[][] 数组名 = new 数据类型[][]{元素1,元素2,...}  //元素 必须是一个数组
            写法二：数据类型[][] 数组名 = {元素1,元素2,...}  //元素 必须是一个数组
        动态初始化：
            数据类型[][] 数组名 = new 数据类型[长度1][长度2]; //长度1表示外层数组长度，长度2表示内部数组的长度
    访问数组：数组名[行索引][列索引]

 */
public class Demo4 {

    public static void main(String[] args) {

        // 数据类型[][] 数组名 = {元素1,元素2,...}  //元素 必须是一个数组
        int[][] arr = {{10,20,30},{40,50,60},{70,80,90}};

        //访问数组：数组名[行索引][列索引]
        System.out.println(arr[0][0]);

        //遍历
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
