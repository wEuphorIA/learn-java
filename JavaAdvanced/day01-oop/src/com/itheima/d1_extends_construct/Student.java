package com.itheima.d1_extends_construct;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 上午10:42 */
public class Student {
    private String name;
    private int age;
    private String school;

    public Student() {
    }
    public Student(String name, int age) {
        this(name, age, null);
    }
    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = "黑马程序员";
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
