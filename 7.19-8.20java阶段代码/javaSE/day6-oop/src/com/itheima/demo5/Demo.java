package com.itheima.demo5;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午4:47
 */
/*
    static修改成员变量
        静态变量：被static修饰的成员变量叫做静态变量，属于类的，被类的所有对象共享。 访问：类名.静态变量名
        实例/非静态变量：没有被static修饰的成员变量，属于对象的，不被共享。 访问：对象.实例变量名
 */
public class Demo {
    public static void main(String[] args) {

        // 访问静态变量 访问：类名.静态变量名
        System.out.println(Student.schoolName);

        // 创建对象 访问静态变量不推荐
        Student student = new Student();
        System.out.println(student.schoolName);
        student.schoolName = "传智播客";
        System.out.println(student.schoolName);

        // 创建对象
        // 实例静态变量 访问：对象.实例变量名
        Student s1 = new Student();
        s1.age = 18;
        System.out.println(s1.age);
        Student s2 = new Student();
        s2.age = 19;
        System.out.println(s2.age);

        Student.show();

        int[] arr = {10,20,30,40,50};
        System.out.println(ArrayUtils.sum(arr));
        System.out.println(ArrayUtils.getMax(arr));
        System.out.println(ArrayUtils.getMin(arr));
        ArrayUtils.printArray(arr);

    }
}
