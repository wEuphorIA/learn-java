package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 上午11:16
 */
public class Demo4 {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
                // a++为11 ++a为12 --b为4 ++b为5 + 1 + a--为11
        int res = a++ + ++a - --b - ++b + 1 + a--;
        System.out.println(res); //26
        System.out.println(a);  //11
        System.out.println(b);  //5
    }
}
