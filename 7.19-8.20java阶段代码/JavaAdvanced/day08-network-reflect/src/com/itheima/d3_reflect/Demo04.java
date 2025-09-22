package com.itheima.d3_reflect;
/*
    需求：
    对于任意一个对象，该框架都可以把对象的字段名和对应的值，保存到文件中去
 */
public class Demo04 {
    public static void main(String[] args) throws  Exception{
        Student student = new Student("小王", 18, "男");
        Teacher teacher = new Teacher("小王", 18, "打球", '男', "12345678901", 5000);

        EasyFramework.save(student);
        EasyFramework.save(teacher);
    }
}
