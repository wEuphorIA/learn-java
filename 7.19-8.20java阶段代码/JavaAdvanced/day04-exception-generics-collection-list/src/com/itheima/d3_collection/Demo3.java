package com.itheima.d3_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/*
    目标：演示单列集合的通用遍历方式
 */
public class Demo3 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("脉劫");
        coll.add("康帅傅");
        coll.add("粤利粤");
        coll.add("大个核桃");
        //需求1 ：使用迭代器遍历Collection集合中的每一个元素，并打印输出 PS:只能遍历集合
        /*  Collection集合获取迭代器的方法
                Iterator<E> iterator()	返回集合中的迭代器对象，该迭代器对象默认指向当前集合的第一个元素
            Iterator迭代器中的常用方法
                boolean hasNext()	询问当前位置是否有元素存在，存在返回true ,不存在返回false
                E next()	获取当前位置的元素，并同时将迭代器对象指向下一个元素处。
        */

        // 1.1 获取迭代器对象
        Iterator<String> iterator = coll.iterator();

        // 1.2 while 循环遍历
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
        System.out.println("----------------");

        //需求2 ：使用增强for遍历Collection集合中的每一个元素，并打印输出 PS:数组和集合都可以使用
        for (String name : coll) {
            System.out.println(name);
        }
        System.out.println("----------------");

        //需求3 ：使用forEach()+Lambda表达式遍历Collection集合中的每一个元素，并打印输出 PS:jdk1.8后提供,只能遍历集合
        // default void forEach(Consumer<? super T> action):  结合Lambda表达式遍历集合：

        //匿名内部类的格式
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("----------------");

        //Lambda表达式的格式
        coll.forEach(s -> System.out.println(s));
        System.out.println("----------------");

        //方法引用
        coll.forEach(System.out::println);
    }
}
