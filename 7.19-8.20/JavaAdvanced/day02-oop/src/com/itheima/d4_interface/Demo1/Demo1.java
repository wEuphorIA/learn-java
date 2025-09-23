package com.itheima.d4_interface.Demo1;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 上午11:53 */
/*
    接口：是一种标准或者规范，用来规定某些类具有相同行为。
    使用步骤：
        第一步：使用interface关键字定义接口
        第二步：定义类使用接口，重写所有抽象方法
    注意实现：
        1、接口不能创建对象
        2、接口中的变量是常量，默认被public static final修饰
        3、接口中的方法默认抽象方法，被public abstract修饰
 */
public class Demo1 {
    public static void main(String[] args) {

        //1、接口不能创建对象
        // A a = new A();
        B b = new B();
        b.show();
        b.swing();
    }
}
//第二步：定义类使用接口，重写所有抽象方法
//类可以实现多个接口
class B implements A,C{
    @Override
    public void show() {
        System.out.println("B类实现A接口");
    }

    @Override
    public void swing() {
        System.out.println("B类实现C接口");
    }
}
//第一步：使用interface关键字定义接口

interface A{

    //2、接口中的变量是常量，默认被public static final修饰
    //不给初始值会报错
    String name = "赵敏";

    //3、接口中的方法默认抽象方法，被public abstract修饰
    void show();

}

interface C{
    void swing();
}