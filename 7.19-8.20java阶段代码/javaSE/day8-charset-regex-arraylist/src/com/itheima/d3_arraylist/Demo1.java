package com.itheima.d3_arraylist;

import java.util.ArrayList;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/30 下午3:18
 */
public class Demo1 {
    public static void main(String[] args) {
        // 创建一个arrayList集合
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        System.out.println(list);


        //创建一个存储double的ArrayList集合
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(5.6);
        list1.add(7.8);
        System.out.println(list1);

        //创建一个存储int的ArrayList集合
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println(list2);
    }
}
