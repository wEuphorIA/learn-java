package com.itheima.d1_extends_override;

import java.sql.Array;
import java.util.ArrayList;

public class Demo2Override {
    // 目标:方法重写的应用场景: 子类重写object类的toString（)方法，以便返回对象的内容。
    public static void main(String[] args) {
        Student student = new Student("张无忌",18,'男');
        // 默认输出地址值  ①为什么输出地址值?默认调用Object类的toString方法  ②输出地址值有意义吗? 没意义
        System.out.println(student);
        System.out.println(student.toString()); // 打印输出对象,默认调用toString()方法,toString可以省略不写

        ArrayList<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(13);
        list.add(14);
        System.out.println(list);

        // == 和 equeals 区别?
    }
}

class Student{
    private String name;
    private Integer age;
    private Character sex;

    public Student() {
    }

    public Student(String name, Integer age, Character sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

