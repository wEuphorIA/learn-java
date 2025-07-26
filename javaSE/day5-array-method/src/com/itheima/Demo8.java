package com.itheima;



/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午4:04
 */
/*
    需求：请定义方法，然后按照指定格式打印整型数组中的内容，格式为：[11,22，33，44，55]。
    分析：
        参数列表：(int[] arr)
        返回值：void
        方法内逻辑：
            1 不换行输出打印"["。
            2 遍历数组，判断是不是最后一个元素
            3 如果不是就打印值+逗号，如果是就只打印值+"]"
 */
public class Demo8 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        printArray( arr);
    }

    /**
     * @Description: 打印数组
     * @param: arr
     * @return: void
     * @author Euphoria
     * @date: 2025/7/26 下午4:30
     */
    public static void printArray(int[] arr){
        // 1 不换行输出打印"["。
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            // 2 遍历数组，判断是不是最后一个元素
            // 3 如果不是就打印值+逗号，如果是就只打印值+"]"
            if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(arr[i] + ",");
            }
        }

    }
}
