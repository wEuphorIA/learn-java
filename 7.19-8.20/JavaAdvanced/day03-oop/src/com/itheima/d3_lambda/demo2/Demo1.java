package com.itheima.d3_lambda.demo2;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午2:59 */
//目标: 把匿名内部类实现的学生排序功能,使用lambda重新实现
//优化规则1 : 参数类型全部可以省略不写
//优化规则2 : 如果Lambda表达式中只有一行代码，大括号可以不写，同时要省略分号"；"如果这行代码是return语句，也必须去掉return。
//优化规则3: 如果只有一个参数，参数类型省略的同时"（）"也可以省略，但多个参数不能省略"（）"
public class Demo1 {
    public static void main(String[] args) {
        com.itheima.d2_innerclass.Student[] students = new com.itheima.d2_innerclass.Student[]{
                new com.itheima.d2_innerclass.Student("小王", 18, 180.5),
                new com.itheima.d2_innerclass.Student("小张", 23, 180.5),
                new com.itheima.d2_innerclass.Student("小李", 20, 180.5),
                new com.itheima.d2_innerclass.Student("小赵", 21, 180.5),
                new com.itheima.d2_innerclass.Student("小王", 18, 180.0),
        };
        System.out.println("排序前");
        System.out.println(Arrays.toString(students));
        System.out.println("排序后");

        // 第一次优化：lambda表达式

        /* Arrays.sort(students, (Student o1, Student o2) -> {

            return o1.getAge() - o2.getAge();
        }); */
        //优化规则1：参数类型可以省略不写
        /* Arrays.sort(students, (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        }); */

        //优化规则2：如果Lambda表达式中只有一行代码，大括号可以不写，同时要省略分号”；"如果这行代码是return,也去掉return语句
        Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(Arrays.toString(students));
        //优化规则3: 如果只有一个参数，参数类型省略的同时"（）"也可以省略，但多个参数不能省略"（）"
        Swim s = name -> System.out.println(name + "正在游泳");
        s.swimming("小王");
    }

}
@FunctionalInterface
interface Swim {
    void swimming(String name);
}