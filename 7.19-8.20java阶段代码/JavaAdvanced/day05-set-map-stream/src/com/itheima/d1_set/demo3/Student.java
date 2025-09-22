package com.itheima.d1_set.demo3;

import java.util.Objects;

public class Student implements Comparable<Student>{
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

    // t2.compareTo（t1)
    // t2==this比较者
    // t1=o被比较者
    // 1.规定：如果你认为左边大于右边 请返同正整数
    // 2.规定2：如果你认为左边小于右边 请通回负整数
    // 3.规定3：如果你认为左边等于右边 请返同0
    // 默认就会升序，

    @Override
    public int compareTo(Student o) {
        return this.math - o.math;
    }
}
