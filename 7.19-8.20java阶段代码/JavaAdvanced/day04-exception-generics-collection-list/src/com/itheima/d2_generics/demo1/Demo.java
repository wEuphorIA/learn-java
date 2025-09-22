package com.itheima.d2_generics.demo1;

/*
    目标：演示自定义泛型类
    格式: 修饰符 class 类名<类型变量，类型变量，…> {}
    注意事项: 类型变量建议用大写的英文字母，常用的有：E、T、K、V 等
 */
public class Demo {
    public static void main(String[] args) {
        // 需求：请您模拟ArrayList集合自定义一个集合MyArrayList
        MyArrayList<String> list = new MyArrayList<>();
        list.add("张三");
        list.add("张三丰");
        list.add("张无忌");
        list.removed("张三");
        System.out.println(list);
    }
}
