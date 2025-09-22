package com.itheima.system;

import java.util.ArrayList;

public class TestStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("heima001","张三",23,"西安");
        Student stu2 = new Student("heima002","李四",24,"咸阳");
        Student stu3 = new Student("heima003","王五",25,"渭南");
        list.add(stu1);
        list.add(stu2);
        list.add(stu2);
    }
}
