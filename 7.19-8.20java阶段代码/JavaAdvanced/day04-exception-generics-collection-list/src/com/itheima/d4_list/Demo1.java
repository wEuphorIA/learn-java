package com.itheima.d4_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
目标：演示List集合特点、特有方法、遍历方式
 */
public class Demo1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("脉劫");
        list.add("康帅傅");
        list.add("康帅傅");
        list.add("粤利粤");

        //public void add(int index, E element) 在此集合中的指定位置插入指定的元素
        list.add(1, "Java");
        System.out.println(list);
        System.out.println("---------------------");

        //public E remove(int index) 删除指定索引处的元素，返回被删除的元素
        list.remove(2);
        System.out.println(list);
        System.out.println("---------------------");

        //public E set(int index, E element) 修改指定索引处的元素，返回被修改的元素
        list.set(1, "JS");
        System.out.println(list);
        System.out.println("---------------------");

        //public E get(int index) 返回指定索引处的元素
        String s = list.get(1);
        System.out.println(s);

        //遍历1：fori遍历
        System.out.println("---------------------");
        for (int i = 0; i < list.size(); i++) {
            String s1 = list.get(i);
            System.out.println(s1);
        }

        //遍历2：迭代器遍历
        System.out.println("---------------------");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s2 = iterator.next();
            System.out.println(s2);
        }

        //遍历3：增强for遍历
        System.out.println("---------------------");
        for (String string : list) {
            System.out.println(string);
        }

        //遍历4：forEach()+匿名内部类遍历
        System.out.println("---------------------");
        list.forEach(s1 -> System.out.println(s1));

        System.out.println("---------------------");
        list.forEach(System.out::println);

    }
}
