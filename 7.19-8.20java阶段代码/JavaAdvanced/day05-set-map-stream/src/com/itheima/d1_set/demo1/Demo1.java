package com.itheima.d1_set.demo1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
目标：演示Set集合的特点，运行下面的代码总结HashSet集合、LinkedHashSet集合、TreeSet集合的元素特点
    不同set集合的特点：
        HashSet无序、不重复、无索引。
        LinkedHashSet 有序、不重复、无索引。
        TreeSet 无序、不重复、无索引，可排序

 */
public class Demo1 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(); //HashSet无序、不重复、无索引。
        set1.add("baa");
        set1.add("abc");
        set1.add("abc");
        set1.add("bac");
        set1.add("cba");
        System.out.println("set1 = " + set1);

        System.out.println("-------------------------------------");
        Set<String> set2 = new LinkedHashSet<>(); //LinkedHashSet 有序、不重复、无索引。
        set2.add("baa");
        set2.add("abc");
        set2.add("abc");
        set2.add("bac");
        set2.add("cba");
        System.out.println("set2 = " + set2);


        System.out.println("---------------------------------------");
        Set<String> set3 = new TreeSet<>(); //TreeSet 不重复、无索引，可排序
        set3.add("baa");
        set3.add("abc");
        set3.add("abc");
        set3.add("bac");
        set3.add("cba");
        System.out.println("set3 = " + set3);

    }
}
