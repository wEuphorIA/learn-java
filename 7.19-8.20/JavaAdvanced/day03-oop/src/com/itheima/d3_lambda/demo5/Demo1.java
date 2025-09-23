package com.itheima.d3_lambda.demo5;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午6:07 */
// 目标: 理解特定类型的方法引用
// 需求: 定义一个方法,把数组中的数据按照指定规则排序,排序规则是不区分大小写排序
// 1.准备字符串数组,存储数据
// 如果某个Lambda表达式里只是调用一个特定类型的实例方法，并且前面参数列表中的第一个参数是作为方法的主调，后面的所有参数都是作为该实例方法的入参的，则此时就可以使用特定类型的方法引用。

public class Demo1 {
    public static void main(String[] args) {
        //创建一个字符串数组进行忽略首字母大小写，按照字母排序
        String[] arr = {"Hello", "world", "java", "helloWorld", "helloJava","a","A"};
        //原始写法
        /* Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        }); */
        //1.使用Lambda表达式
        // Arrays.sort(arr,( o1,  o2) -> o1.compareToIgnoreCase(o2));
        //2.使用方法引用
        Arrays.sort(arr, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arr));
    }
}
