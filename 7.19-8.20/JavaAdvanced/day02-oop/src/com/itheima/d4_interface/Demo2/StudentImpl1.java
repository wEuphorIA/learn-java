package com.itheima.d4_interface.Demo2;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午3:56 */
//功能1：能打印出班级全部学生的信息；功能2；能打印班级全部学生的平均分(无需去掉最高分、最低分)。
public class StudentImpl1 implements StudentInter{

    //功能1：能打印出班级全部学生的信息
    @Override
    public void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println( student);
        }
    }

    //功能2；能打印班级全部学生的平均分(无需去掉最高分、最低分)
    @Override
    public void printAverageScore(Student[] students) {
        int sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        System.out.println("平均分：" + sum / students.length);
    }
}
