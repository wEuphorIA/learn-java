package com.itheima.d4_interface.Demo2;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午4:13 */
//第2套方案：功能1：能打印出班级全部学生的信息（男女人数）；功能2：能打印班级全部学生的平均分（要求是去掉最高分、最低分)
public class StudentImpl2 implements StudentInter{

    //第2套方案：功能1：能打印出班级全部学生的信息（男女人数）
    @Override
    public void printStudents(Student[] students) {
        int manCount = 0;
        for (Student student : students){
            if ("男".equals(student.getSex())){
                manCount++;
            }
            System.out.println(student);
        }
        System.out.println("班级共有" + manCount + "个男生");
        System.out.println("班级共有" + (students.length - manCount) + "个女生");
    }

    //功能2：能打印班级全部学生的平均分（要求是去掉最高分、最低分)
    @Override
    public void printAverageScore(Student[] students) {
        double sum = 0;
        double max = students[0].getScore();
        double min = students[0].getScore();
        for (int i = 0; i < students.length; i++){
            sum += students[i].getScore();
            if (students[i].getScore() > max){
                max = students[i].getScore();
            }
            if (students[i].getScore() < min){
                min = students[i].getScore();
            }
        }
        System.out.println("平均分：" + (sum - max - min) / (students.length - 2));

    }
}
