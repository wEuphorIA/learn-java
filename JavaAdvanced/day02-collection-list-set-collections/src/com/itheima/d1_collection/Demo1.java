package com.itheima.d1_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*
目标：演示Collection体系下，各集合的元素特点
 */
public class Demo1 {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("脉劫");
        c1.add("康帅傅");
        c1.add("康帅傅");
        c1.add("粤利粤");
        System.out.println(c1);

        System.out.println("----------------");
        Collection<String> c2 = new HashSet<>();
        c2.add("脉劫");
        c2.add("康帅傅");
        c2.add("康帅傅");
        c2.add("粤利粤");
        System.out.println(c2);
    }
}
