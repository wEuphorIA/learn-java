package com.itheima.d1_collection;

import java.util.ArrayList;
import java.util.Collection;

/*
    目标：演示单列集合的通用遍历方式
 */
public class Demo3 {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("脉劫");
        c1.add("康帅傅");
        c1.add("粤利粤");
        c1.add("大个核桃");
        //需求1 ：使用迭代器遍历Collection集合中的每一个元素，并打印输出
        //需求2 ：使用增强for遍历Collection集合中的每一个元素，并打印输出
        //需求3 ：使用forEach()+Lambda表达式遍历Collection集合中的每一个元素，并打印输出
    }
}
