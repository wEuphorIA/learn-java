package com.itheima.d2_innerclass;

import java.util.Arrays;
import java.util.Comparator;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午2:59 */
public class Demo5 {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("小王", 18, 180.5),
                new Student("小张", 23, 180.5),
                new Student("小李", 20, 180.5),
                new Student("小赵", 21, 180.5),
                new Student("小王", 18, 180.0),
        };
        System.out.println("排序前");
        System.out.println(Arrays.toString(students));
        System.out.println("排序后");
        // 按照年龄对学生排序
        /*
            public static <T> void sort(T[] a, Comparator<T> c)
            参数1:要被排序的数据
            参数2:Comparator接口的对象,用来指定排序规则
         */
        Arrays.sort(students, new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 用来指定排序规则
                // 左边对象如果大于右边对象,返回正数 => 左边对象向后移动
                // 左边对象如果小于右边对象,返回负数 => 左边对象向前移动
                // 左边对象如果等于右边对象,返回零   => 顺序不变
                /* if (o1.getAge() > o2.getAge()){
                    return 1;
                } else if (o1.getAge() < o2.getAge()) {
                    return -1;
                }else {
                    return 0;
                } */
                // return o1.getAge() - o2.getAge();//按年龄升序排序

                // int result = o1.getAge() - o2.getAge();
                // if (result == 0) {
                //     result = Double.compare(o2.getHeight(), o1.getHeight());
                // }


                // return o1.getAge() - o2.getAge() == 0 ? Double.compare(o2.getHeight(), o1.getHeight()) : o1.getAge() - o2.getAge();//按年龄升序排序 如果年龄一样，按照身高降序


                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(Arrays.toString(students));
    }

}

/* class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // 用来指定排序规则
        // 左边对象如果大于右边对象,返回正数 => 左边对象向后移动
        // 左边对象如果小于右边对象,返回负数 => 左边对象向前移动
        // 左边对象如果等于右边对象,返回零   => 顺序不变
        if (o1.getAge() > o2.getAge()){
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        }else {
            return 0;
        }
    }
} */
