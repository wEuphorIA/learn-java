package com.itheima.d2_map;

import java.util.*;

public class Demo1 {
    public static void main(String[] args) {
        //目标：演示Map集合特点
        //创建一个Map集合
       Map<String, Integer> map = new HashMap<>(); //经典写法 无序、不重复、无索引       键值对都可以为空
       // Map<String, Integer> map = new LinkedHashMap<>(); //有序、不重复、无索引   键值对都可以为空
       // Map<String, Integer> map = new TreeMap<>();//可排序、不重复、无索引         键不能为空

        //给map集合中添加元素 put方法返回值：返回旧值
        map.put("张三", 29);
        map.put("李四", 28);
        map.put("王五", 27);
        map.put("赵六", 26);
        map.put("李四", 33);
        Integer i2 = map.put("赵六", 66);
        System.out.println(i2);
        Integer i1 = map.put("孙七", 27);
        System.out.println(i1);
        map.put("重八", null);
       // map.put(null, null);

        System.out.println(map);
    }
}
