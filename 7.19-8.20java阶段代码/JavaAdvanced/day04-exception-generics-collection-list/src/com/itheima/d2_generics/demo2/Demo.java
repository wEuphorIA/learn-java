package com.itheima.d2_generics.demo2;

/*
    目标：演示自定义泛型接口
    格式: 修饰符 interface 接口名<类型变量，类型变量，…> {}
    需求: 项目需要对学生数据/老师数据都要进行增删改查操作
 */
public class Demo {
    public static void main(String[] args) {
        Data<Student> studentData = new StudentData();
        studentData.add(new Student());
    }
}
