package com.itheima.d2_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    目标：演示Stream流的终结方法
    void forEach (Consumer action) 对此流运算后的元素执行遍历
    long count () 统计此流运算后的元素个数
    Optional<T> max (Comparator<? super T> comparator) 获取此流运算后的最大值元素
    Optional<T> min (Comparator<? super T> comparator) 获取此流运算后的最小值元素
 */
public class Demo4 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精", 26, 172.5);
        Student s2 = new Student("蜘蛛精", 26, 172.5);
        Student s3 = new Student("紫霞", 23, 167.6);
        Student s4 = new Student("白晶晶", 25, 169.0);
        Student s5 = new Student("牛魔王", 35, 183.3);
        Student s6 = new Student("牛夫人", 34, 168.5);
        Collections.addAll(students, s1, s2, s3, s4, s5, s6);
        // 需求1：请计算出身高超过168的学生有几人。
        System.out.println("1 -----------------------------");

        // 需求2：请找出身高最高的学生对象，并输出。
        System.out.println("2 -----------------------------");

        // 需求3：请找出身高最矮的学生对象，并输出。
        System.out.println("3 -----------------------------");
    }

}

