package com.itheima.d1_exception;

/*
目标：异常的作用
1.异常的作用：①异常是用来定位程序bug的关键信息
            ②可以作为方法内部的一种特殊返回值,以便通知上层调用者，方法的执行问题
 */
public class Demo2 {
    public static void main(String[] args) {
        //需求1：定义一个方法,两个数相除,返回结果
        int div = div(10, 0);
        System.out.println(div);
    }
    public static int div(int a, int b) {
        if (b == 0){
            throw new RuntimeException("除数不能为0");
        }
        return a / b;
    }
}
