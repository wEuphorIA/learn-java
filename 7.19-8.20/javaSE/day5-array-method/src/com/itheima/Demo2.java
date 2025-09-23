package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 上午10:59
 */
/*
    访问数组中的元素（值）
        获取值：数组名[索引]
        赋 值：数组名[索引]=值;
            索引：就是元素在数组中的位置(编号)，从0开始
        获取数组的长度：数组名.length; 最大索引 = 数组.length-1
 */
public class Demo2 {
    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};

        //获取值：数组名[索引]
        System.out.println(arr[0]);

        //赋 值：数组名[索引]=值;
        arr[0] = 100;
        System.out.println(arr[0]);

        //获取数组的长度：数组名.length; 最大索引 = 数组.length-1
        System.out.println(arr.length);
        System.out.println(arr[arr.length-1]);

    }

}
