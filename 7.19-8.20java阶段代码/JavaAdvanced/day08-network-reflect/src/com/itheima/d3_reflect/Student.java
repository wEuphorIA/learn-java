package com.itheima.d3_reflect;

public class Student {
    private String name;
    private int age;
    public String gender;

    private Student() {
        System.out.println("无参构造方法执行");
    }

    public Student(String name) {
        System.out.println("带1个参数构造方法执行");
        this.name = name;
    }

    public Student(String name, int age) {
        System.out.println("带2个参数构造方法执行");
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String gender) {
        System.out.println("带3个参数构造方法执行");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    private void show() {
        System.out.println("我是私有方法！");
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
