package com.itheima.d1_set.demo3;

import java.util.Comparator;
import java.util.TreeSet;

/*
目标：演示往TreeSet集合中添加Student对象，并按照两种方式对元素进行排序
    排序方式一：在创建TreeSet集合时，传递一个比较器对象，比较器是Comparator接口的实现类对象

    排序方式二：排序方式二：让元素类实现Comparable接口，实现compareTo方法

 */
public class Demo3 {
    public static void main(String[] args) {

        //排序方式一：在创建TreeSet集合时，传递一个比较器对象，比较器是Comparator接口的实现类对象
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("小王", 98, 88));
        students.add(new Student("小张", 98, 90));
        students.add(new Student("小李", 98, 56));
        students.add(new Student("小赵", 98, 95));
        students.add(new Student("小钱", 98, 50));
        //排序方式二：让元素类实现Comparable接口，实现compareTo方法


        students.forEach(System.out::println);
    }
}
