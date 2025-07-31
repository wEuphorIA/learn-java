package com.itheima.d3_set.demo1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/*
目标：演示Set集合的特点，运行下面的代码总结HashSet集合、LinkedHashSet集合、TreeSet集合的元素特点
    不同set集合的特点：
        HashSet无序、不重复、无索引。
        LinkedHashSet 有序、不重复、无索引。
        TreeSet 可排序、不重复、无索引

 */
public class Demo1 {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>(); //HashSet无序、不重复、无索引。


        System.out.println("-------------------------------------");
        LinkedHashSet<String> set2 = new LinkedHashSet<>(); //LinkedHashSet 有序、不重复、无索引。



        System.out.println("---------------------------------------");
        TreeSet<String> set3 = new TreeSet<>(); //TreeSet 可排序、不重复、无索引


    }
}
