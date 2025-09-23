package com.itheima.d3_stream;

import java.util.*;
import java.util.stream.Collectors;

/*
    目标：收集Stream流中的数据到集合或者数组中
    Stream提供的常用终结方法
        R collect (Collector collector) 把流处理后的结果收集到一个指定的集合中去
        Object[] toArray() 把流处理后的结果收集到一个数组中去
    Collectors工具类提供了具体的收集方式
        public static <T> Collector toList () 把元素收集到List集合中 stream.collect(Collectors.toList())
        public static <T> Collector toSet () 把元素收集到Set集合中  stream.collect(Collectors.toSet())
        public static  Collector toMap (Function keyMapper , Function valueMapper) 把元素收集到Map集合中
 */
public class Demo5 {
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
        // 需求1：请找出身高超过170的学生对象，并放到一个新集合中去返回。
        List<Student> collect = studentList.stream().filter(s -> s.getHeight() > 170).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("2 -----------------------------");
        Set<Student> newSet = studentList.stream().filter(s -> s.getHeight() > 170).collect(Collectors.toSet());
        System.out.println(newSet);

        System.out.println("3 -----------------------------");
        // 需求2：请找出身高超过170的学生对象，并把学生对象的名字和身高，存入到一个Map集合返回。
        Map<String, Double> newMap = studentList.stream().filter(s -> s.getHeight() > 170)
                .distinct()
                .collect(Collectors.toMap(s -> s.getName(), s -> s.getHeight()));

        System.out.println(newMap);

        System.out.println("4 -----------------------------");
        // 需求3：请找出身高超过170的学生对象，存到一个数组中去
        Object[] array = studentList.stream().filter(s -> s.getHeight() > 170).toArray();
        System.out.println(Arrays.toString(array));

    }
}
