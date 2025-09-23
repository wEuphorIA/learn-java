package com.itheima.d4_interface.Demo2;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午3:13 */
/*
   需求：请设计一个班级学生的信息管理模块：学生的数据有：姓名、性别、成绩。请提供一个类，完成如下两个功能
    功能1：要求打印出全班学生的信息；
    功能2：要求打印出全班学生的平均成绩。
   注意！以上功能的业务实现是有多套方案的，比如：
   第1套方案：功能1：能打印出班级全部学生的信息；功能2；能打印班级全部学生的平均分(无需去掉最高分、最低分)。
   第2套方案：功能1：能打印出班级全部学生的信息（男女人数）；功能2：能打印班级全部学生的平均分（要求是去掉最高分、最低分)
   要求：系统可以支持灵活的切换这些实现方案。

   实现步骤：
     第一步：定义Student实体类，封装学的姓名、性别、成绩
     第二步：定义一个接口，在接口中定义 功能1(printStudents)和功能2(printAverageScore) 对应的方法
     第三步：定义"第1套方案"实现类，重写方法，完成对应的功能
     第四步：定义"第2套方案"实现类，重写方法，完成对应的功能
     第五步：在main方法中，创建实现类对象，调用方法，完成功能输出。
 */
public class Demo1 {
    public static void main(String[] args) {

        Student[] students = new Student[5];
        students[0] = new Student("小王", "男", 90);
        students[1] = new Student("小张", "女", 80);
        students[2] = new Student("小李", "男", 75);
        students[3] = new Student("小王", "女", 70);
        students[4] = new Student("小王", "男", 95);

        StudentInter studentInter = new StudentImpl1();
        studentInter.printStudents(students);
        studentInter.printAverageScore(students);

        studentInter = new StudentImpl2();
        studentInter.printStudents(students);
        studentInter.printAverageScore(students);
    }
}
