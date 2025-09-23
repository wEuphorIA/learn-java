package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/24 下午3:06
 */
public class Demo11 {
    public static void main(String[] args) {

        //1 在循环外定义一个求和变量sum，初始值是0；
        int sum = 0;
        //2 使用循环生成1~10之间的奇数
        int i = 1;
        while ( i <= 10) {
            //3 在循环中，将生成的奇数累加到sum身上
            sum += i;
            i+=2;
        }
        //4 循环结束后，打印sum的值即为求和结果
        System.out.println("sum = " + sum);

    }
}
