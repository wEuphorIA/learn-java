package com.itheima.demo4;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午4:09
 */
/*
    javabean类：也叫实体类，需要满足如下要求：
        1、类中的成员变量都需要私有化，并提供public修饰的get/set方法。
        2、必须要有空参构造，有参构造可有可无。
    生成构造器：
        快捷键：alt+(fn)+insert/ins--->constructor--->点击select none 按钮
        快捷键：alt+(fn)+insert/ins--->constructor--->选择要赋值的成员变量--->ok
    生成get/set方法：
        快捷键：alt+(fn)+insert/ins--->getter and setter--->选择要生成get/set方法的成员变量--->ok
    生成toString方法：
        快捷键：alt+(fn)+insert/ins--->getter and setter--->选择要生成get/set方法的成员变量--->ok
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
