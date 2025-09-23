package com.itheima.d4_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    目标：演示可变参数的用法，Collections工具类的常用方法
 */
public class Demo2 {
    public static void main(String[] args) {

        List<Teacher> teachers = new ArrayList<>();
        Teacher t1 = new Teacher("小王", 18, 5000.0);
        Teacher t2 = new Teacher("小明", 28, 4000.0);
        Teacher t3 = new Teacher("小李", 20, 3000.0);

        //public static <T> boolean addAll(Collection<? super T> c, T...elements) 给集合批量添加元素
        Collections.addAll(teachers, t1, t2, t3);

        //public static void shuffle(List<?> list) 打乱List集合中的元素顺序
        Collections.shuffle(teachers);
        System.out.println(teachers);

        //public static <T> void sort(List<T> list) 对List集合中的元素进行升序排序
        Collections.sort(teachers);
        System.out.println(teachers);

        //public static <T> void sort(List<T> list, Comparator<? super T> c) 对List集合中元素按照比较器对象指定的规则进行排序
        Collections.sort(teachers, (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        System.out.println(teachers);

    }
}
