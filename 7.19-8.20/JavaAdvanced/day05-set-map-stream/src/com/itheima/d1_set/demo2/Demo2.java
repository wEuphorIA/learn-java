package com.itheima.d1_set.demo2;

import java.util.HashSet;
import java.util.Set;

/*
    目标：掌握HashSet去重操作
    需求：
        创建一个存储学生对象的集合，存储多个学生对象，要求：多个学生对象的成员变量值相同时，我们就认为是同一个对象，要求只保留一个。
    分析
        定义学生类，创建HashSet集合对象, 创建学生对象
        把学生添加到集合
        在学生类中重写两个方法，hashCode()和equals()，自动生成即可
        遍历集合(增强for)
 */
public class Demo2 {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        set.add(new Student("小王", 18));
        set.add(new Student("小红", 20));
        set.add(new Student("小王", 18));
        set.add(new Student("小明",22));

        System.out.println(set);
    }
}
