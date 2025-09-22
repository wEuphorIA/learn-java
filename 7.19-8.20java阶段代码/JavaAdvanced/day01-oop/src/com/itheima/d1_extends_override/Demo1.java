package com.itheima.d1_extends_override;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午6:08 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(new A("张无忌", 18));
    }
}
class A{
    private String name;
    private int age;

    public A() {
    }

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
