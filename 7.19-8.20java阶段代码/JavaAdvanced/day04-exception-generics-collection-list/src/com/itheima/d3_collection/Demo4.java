package com.itheima.d3_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    目标：理解集合的并发修改异常问题，以及三种遍历方式的区别
    ConcurrentModificationException并发修改异常
    原因：使用迭代器遍历集合的同时，调用了集合的方法（改变了集合元素的个数）
    解决: 使用迭代器自己的删除方法remove(Object obj)来删除元素
    区别:
        ① 如果集合支持索引，可以使用for循环遍历，每删除数据后做i--；或者可以倒着遍历
        ② 可以使用迭代器遍历，并用迭代器提供的删除方法删除数据。
        注意：增强for循环/Lambda遍历均不能解决并发修改异常问题，因此增它们只适合做数据的遍历，不适合同时做增删操作。

 */
public class Demo4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        list.add("西洋参");
        System.out.println(list);
        // 需求：删除名字中带枸杞的所有商品
        // 方式一: 使用迭代器删除
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.contains("枸杞")) {
                // list.removeIf(a -> a.contains("枸杞"));
                iterator.remove();
            }
        }
        System.out.println(list);

        // 方式二和方式三: 增强for循环和foreach(都会发生并发修改异常) ConcurrentModificationException
        for (String s : list) {
            if (s.contains("枸杞")) {
                list.remove(s);
            }
        }

        list.forEach(s -> {
            if (s.contains("枸杞")) {
                list.remove(s);
            }
        });
        // list.removeIf(s -> s.contains("枸杞"));
        System.out.println(list);

    }
}
