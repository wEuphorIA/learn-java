package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午3:07
 */
public class Demo12 {
    public static void main(String[] args) {
        //在循环外定义一个变量count，初始值为0，用于统计水仙花数的个数
        int count = 0;

        // 1、定义一个for循环从“100一直到999"
        int i = 100;
        while (i <= 999) {
            // 2、在循环中获取每个数的个位、十位、百位数字。
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            // 3、使用if判断：个位、十位、百位的数字立方和是否等于原数，等于则输出该数据
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println(i);
                count++;
            }
            i++;
        }

        System.out.println("count = " + count);
    }
}
