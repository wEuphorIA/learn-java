package com.itheima.d2_generics.demo4;

import java.util.ArrayList;
import java.util.List;

    //目标：演示泛型通配符、上下限、泛型擦除
public class Demo {
    public static void main(String[] args) {
        //创建集合对象，添加狗，调用print方法遍历打印集合
        List<Dog> list1=new ArrayList<>();
        list1.add(new Dog("旺财"));
        list1.add(new Dog("大黄"));

        //创建集合对象，添加猫，调用print方法遍历打印集合
        List<Cat> list2=new ArrayList<>();
        list2.add(new Cat("花卷"));
        list2.add(new Cat("毛毛"));

    }

    //需求：定义一个print方法，实现遍历打印集合中的动物对象
}
