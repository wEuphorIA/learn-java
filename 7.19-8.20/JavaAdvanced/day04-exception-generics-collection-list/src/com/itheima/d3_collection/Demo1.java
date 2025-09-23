package com.itheima.d3_collection;

import java.util.*;

/*
目标：演示Collection体系下，各集合的元素特点
 */
public class Demo1 {
    public static void main(String[] args) {
        // List系列集合：添加的元素是有序、可重复、有索引。
        List<String> c1 = new ArrayList<>();
        c1.add("脉劫");
        c1.add("康帅傅");
        c1.add("康帅傅");
        c1.add("粤利粤");
        System.out.println(c1);

        System.out.println("----------------");

        //  Set系列集合：添加的元素是无序、不可重复、无索引。
        Set<String> c2 = new HashSet<>();
        c2.add("脉劫");
        c2.add("康帅傅");
        c2.add("康帅傅");
        c2.add("粤利粤");
        System.out.println(c2);
    }
}
