package com.itheima.d1_extends;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午2:57 */
public class Demo1 {
    public static void main(String[] args) {
        //继承的作用：代码复用，减少代码的重复性
        //子类能继承父类的非私有变量和成员方法
        //继承后的子类对象由子类和父类共同完成

        Consultent c = new Consultent();
        c.setName("小王");
        c.setAge(18);
        c.setCount(100);
        Teacher t = new Teacher();
        t.setName("小王");
        t.setAge(18);
        t.setSkill("java");
        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getSkill());

        System.out.println(c.getName());
        System.out.println(c.getAge());
        System.out.println(c.getCount());

    }
}
