package com.itheima.d3_reflect;

/**
  目标：掌握获取Class类对象的三种方式
  需求：分别利用三种方式获取Student类的字节码对象
  获取Class类对象的三种方式：
       方式1：Class类静态方法forName(String className)
       方式2：类名.class
       方式3：对象.getClass()

 */
public class Demo01 {
    public static void main(String[] args) throws Exception {

        Class cla1 = Class.forName("com.itheima.d3_reflect.Student");

        System.out.println(cla1.getName());
        System.out.println(cla1.getSimpleName());

        Class cla2 = Student.class;

        Student student = new Student("");
        Class cla3 = student.getClass();

        System.out.println(cla1 == cla2);
        System.out.println(cla2 == cla3);

    }
}
