package com.itheima;

import java.util.Optional;

/**
 * @author Euphoria
 * @version 1.0
 * @description: 字面量练习
 * @date 2025/7/21 上午9:55
 */
/*
    字面量：数据在程序中的书写格式
    分类：
        整数               666,-88
        小数              13.14,-5.21
        字符              用单引号引起来，例如：'我'、'a'、'1'
        字符串             用双引号引起来，例如："我爱西安"、""、"a"
        布尔值             true表示真，false表示假
        空值              null
        特殊字符字面量     \t  \n
 */
public class Demo2 {
    public static void main(String[] args) {
        //整数               666,-88
        System.out.println(666);
        System.out.println(-88);
        //小数              13.14,-5.21
        System.out.println(13.14);
        System.out.println(-5.21);
        //字符              用单引号引起来，例如：'我'、'a'、'1'
        System.out.println('我');
        System.out.println('a');
        System.out.println('1');
        //字符串             用双引号引起来，例如："我爱西安"、""、"a"
        System.out.println("我爱西安");
        System.out.println("");
        System.out.println("a");

        //布尔值true表示真，false表示假
        System.out.println(true);
        System.out.println(false);

        //空值              null
        System.out.println(Optional.ofNullable(null));
        // 特殊字符字面量     \t  \n
        System.out.println("hello\tworld");
    }
}
