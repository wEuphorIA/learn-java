package com.itheima;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/26 下午5:40
 */

/*
    需求：在唱歌比赛中，可能有多名评委要给选手打分，分数是[0－100]之间的整数。
    选手最后得分为去掉最高分、最低分后剩余分数的平均分，请编写程序计算n位评委为选手的打分，
    并返回选手的最终得分(getAverageScore)


    分析：
        参数列表：需要接收评委的人数，参数类型：(int n)
        返回值：需要返回计算出的选手最终得分，返回值：double类型
       方法内逻辑：
            //1 一个动态初始化长度为n的数组，用于保存评委打分。
            //2 创建键盘录入scanner对象。
            //3 遍历数组，提示并录入评委分数保存到数组。
            //4 遍历数组，获取总分、最高分、最低分。
            //5 循环结束后计算平均分并返回。
 */
public class Demo12 {
    public static void main(String[] args) {

        double averageScore = getAverageScore(6);
        System.out.println("去掉最大最小值后的平均值 = " + averageScore);

    }
    public static double getAverageScore(int n){

        //1 一个动态初始化长度为n的数组，用于保存评委打分。
        int[] arr = new int[n];

        //2 创建键盘录入scanner对象。
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            //3 遍历数组，提示并录入评委分数保存到数组。
            System.out.println("请输入第" + (i + 1) + "个评委的打分：");
            arr[i] = sc.nextInt();
        }
        //4 遍历数组，获取总分、最高分、最低分。
        double sum = 0;
        double max = arr[0];
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return (sum - max - min) / (arr.length - 2);
    }
}
