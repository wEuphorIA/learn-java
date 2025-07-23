package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 上午11:02
 */
/*
    自增自减运算符：
        自增：++，放在某个变量前面或者后面，对变量自身的值加1
        自减：--，放在某个变量前面或者后面，对变量自身的值减1
    注意事项：
        1、++或者-- 只能操作变量，不能操作字面量
        2、++或者-- 单独使用放在变量前后没有区别。
        3、如果是单独使用，++/-- 放在前面或者后面没有区别。
        4、如果不是单独使用（参与运算、赋值、打印），放在前面获取后面右明显的区别。
            放在前，先加1或者减1，再使用变量
            放在后，先使用变量，变量再加1或者减1，

 */
public class Demo3 {
    public static void main(String[] args) {

        int a = 10;
        // 如果是单独使用，++/-- 放在前面或者后面没有区别。
        a++;
        System.out.println(a);

        a--;
        System.out.println(a);

        System.out.println();

        // 放在前，先加1或者减1，再使用变量
        System.out.println(a++); // 10
        System.out.println(a);

        //放在后，先使用变量，变量再加1或者减1，
        System.out.println(++a); // 12
        System.out.println(a);

        System.out.println();

        System.out.println(--a); // 11
        System.out.println(a);

        System.out.println(a--); // 11
        System.out.println(a);

    }
}
