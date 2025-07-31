package com.itheima.d3_set.demo3;

import java.util.Objects;

public class Student {
    private String name;
    private int math;   //数学成绩
    private int chinese;   //语文成绩

    public Student() {
    }
    public Student(String name, int math, int chinese) {
        this.name = name;
        this.math = math;
        this.chinese = chinese;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", math=" + math +
                ", chinese=" + chinese +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return math == student.math && chinese == student.chinese && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, math, chinese);
    }
}
