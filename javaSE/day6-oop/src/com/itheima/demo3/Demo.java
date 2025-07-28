package com.itheima.demo3;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午12:03
 */
/*
    封装：将类的某些信息(属性)隐藏在类的内部，不允许外部直接访问，而是通过该类提供的方法来访问。
    封装是面向对象的三大特征之一，面向对象的三大特征是封装、继承、多态。
    实现/步骤：
        第一步：使用private关键字修饰成员变量，表示私有，外面就无法直接访问
        第二步：给成员变量提供set和get方法来间接访问成员变量
 */
public class Demo {
    public static void main(String[] args) {

        Student student = new Student();

        //student.name = "张三"; 报错 设置属性后不能直接访问

        //调用get和set方法访问成员变量
        student.setName("张三");
        student.setAge(-18);
        //取值
        System.out.println(student.getName() + "," + student.getAge());
    }
}
