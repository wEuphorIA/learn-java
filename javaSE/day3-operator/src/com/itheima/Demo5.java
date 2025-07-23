package com.itheima;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 上午11:55
 */
/*
    赋值运算符：给变量赋值的
        基本赋值运算符：=
        扩展赋值运算符：+= -= *= /= %=
            例如：a+=b  等价于  a=(a的类型)(a+b)
            例如：a-=b  等价于  a=(a的类型)(a-b)
            例如：a*=b  等价于  a=(a的类型)(a*b)
            注意：扩展的赋值运算符隐含了强制类型转换.
 */
public class Demo5 {
    public static void main(String[] args) {

        byte a = 10;
        int  b = 20;

        // 扩展的赋值运算符隐含了强制类型转换.
        a += b; // a = (byte)(a + b)
        System.out.println(a);
        a -= b;
        System.out.println(a);
        a *= b;
        System.out.println(a);
        a /= b;
        System.out.println(a);
    }
}

