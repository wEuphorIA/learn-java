package com.itheima.d3_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*
    目标：演示Stream流的终结方法
    void forEach (Consumer action) 对此流运算后的元素执行遍历
    long count () 统计此流运算后的元素个数
    Optional<T> max (Comparator<? super T> comparator) 获取此流运算后的最大值元素
    Optional<T> min (Comparator<? super T> comparator) 获取此流运算后的最小值元素
 */
public class Demo4 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student("蜘蛛精", 26, 172.5);
        Student s2 = new Student("蜘蛛精", 26, 172.5);
        Student s3 = new Student("紫霞", 23, 167.6);
        Student s4 = new Student("白晶晶", 25, 169.0);
        Student s5 = new Student("牛魔王", 35, 183.3);
        Student s6 = new Student("牛夫人", 34, 168.5);
        Collections.addAll(studentList, s1, s2, s3, s4, s5, s6);

        System.out.println("1 -----------------------------");
        // 需求1：请计算出身高超过168的学生有几人。
        long count = studentList.stream().filter(s -> s.getHeight() > 168).count();
        System.out.println(count);

        System.out.println("2 -----------------------------");
        // 需求2：请找出身高最高的学生对象，并输出。
        Optional<Student> max = studentList.stream().max((stu1, stu2) -> Double.compare(stu1.getHeight(), stu2.getHeight()));
        System.out.println(max.get());
        System.out.println("3 -----------------------------");
        // 需求3：请找出身高最矮的学生对象，并输出。
        Optional<Student> min = studentList.stream().min((stu1, stu2) -> Double.compare(stu1.getHeight(), stu2.getHeight()));
        System.out.println(min.get());
    }

}

