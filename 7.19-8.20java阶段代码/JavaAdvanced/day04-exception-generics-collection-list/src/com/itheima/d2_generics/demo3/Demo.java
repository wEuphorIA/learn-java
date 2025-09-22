package com.itheima.d2_generics.demo3;

import java.util.Arrays;

/*
    目标：演示自定义泛型方法
    格式: 修饰符 <类型变量，类型变量，…>  返回值类型 方法名(形参列表) {}
    需求: 定义一个方法，打印输出任意类型的数组
 */
public class Demo {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        printArray(arr);

        String[] arr2 = {"张三","李四","王五"};
        printArray(arr2);
    }

    public static <E> void printArray(E[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
