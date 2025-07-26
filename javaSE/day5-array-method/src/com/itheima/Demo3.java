package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 上午11:11
 */
/*
    遍历数组：通过循环访问数组中的每个元素
    语法：
        for(int i = 0; i < 数组名.length; i++){
            数组名[i]
        }
    快捷键：数组名.fori+回车  或者  数组名.forr+回车
 */
public class Demo3 {
    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};
        // 快捷键：数组名.fori+回车
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("===================");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }

    }
}
