package com.itheima.d4_interface.Demo2;
//第二步：定义一个接口，在接口中定义 功能1(printStudents)和功能2(printAverageScore) 对应的方法
public interface StudentInter {

    void printStudents(Student[] students);

    void printAverageScore(Student[] students);
}
