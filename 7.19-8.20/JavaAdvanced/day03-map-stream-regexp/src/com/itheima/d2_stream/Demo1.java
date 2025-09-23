package com.itheima.d2_stream;

import java.util.ArrayList;
import java.util.List;

/*
    目标：分别使用传统方式、Stream API完成下面的需求。体验Stream流的优势
    需求：把集合中所有以“张”开头，且是3个字的元素存储到一个新的集合,最后遍历打印新集合中的数据。
 */
public class Demo1 {
    public static void main(String[] args) {
        //创建一个集合，添加若干个元素
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        //传统方式----------------------------
        List<String> newList=new ArrayList<>();
        for (String name : list) {
            //把集合中所有以"张"开头，且是3个字的元素存储到一个新的集合
            if(name.startsWith("张") && name.length()==3){
                newList.add(name);
            }
        }
        for (String name : newList) {
            System.out.println(name);
        }
        //使用Stream流----------------------------

    }
}
