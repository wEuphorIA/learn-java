package com.itheima.d2_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    目标：Stream流的中间方法。掌握中间方法的特点
    Stream<T> filter(Predicate<? super T> predicate) 用于对流中的数据进行过滤。
    Stream<T> sorted() 对元素进行升序排序
    Stream<T> sorted (Comparator<? super T> comparator) 按照指定规则排序
    Stream<T> limit (long maxSize) 获取前几个元素
    Stream<T> skip (long n) 跳过前几个元素
    Stream<T> distinct () 去除流中重复的元素。
    <R> Stream<R> map (Function<? super T, ? extends R> mapper) 将流中的T元素转换成R元素，并返回对应的新流。
    static <T> Stream<T> concat (Stream a, Stream b) 合并a和b两个流为一个流
 */
public class Demo3 {
    public static void main(String[] args) {
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores, 88.5, 100.0, 60.0, 99.0, 9.5, 99.6, 25.0);
        // 需求1：找出成绩大于等于60分的数据，并升序后，再输出。
        System.out.println("1 -----------------------------");

		
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精", 26, 172.5);
        Student s2 = new Student("蜘蛛精", 26, 172.5);
        Student s3 = new Student("紫霞", 23, 167.6);
        Student s4 = new Student("白晶晶", 25, 169.0);
        Student s5 = new Student("牛魔王", 35, 183.3);
        Student s6 = new Student("牛夫人", 34, 168.5);
        Collections.addAll(students, s1, s2, s3, s4, s5, s6);
		// 需求2：找出年龄大于等于23,且年龄小于等于30岁的学生，并按照年龄降序输出
        System.out.println("2 -----------------------------");

        // 需求3：取出身高最高的前3名学生，并输出。
        System.out.println("3 -----------------------------");

        // 需求4：取出身高倒数的2名学生，并输出
        System.out.println("4 -----------------------------");

        // 需求5：找出身高超过168的学生、去除重复的学生（属性值相同，则认为元素重复）、获取所有学生的姓名、并输出
        System.out.println("5 -----------------------------------");

        // 需求6：将以下两个集合中的数据合并后输出
		System.out.println("6 -----------------------------------");
        List<Integer> list1 = List.of(10, 20, 30, 40, 50);
        List<Integer> list2 = List.of(100, 200, 300, 400, 500);
        
    }
}
