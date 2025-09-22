package com.itheima.d2_innerclass;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 上午9:50 */
/*
    成员内部类：就是定义在一个类成员位置的内部类就叫成员内部类，类似于成员变量、成员方法的定义。
 */
//  如何创建内部类对象：外部类名.内部类名 对象名=new 外部类(...).new 内部类(...);成员内部类的访问特点：
    //1 成员内部类中可以直接访问外部类的实例成员、静态成员。
    //2 成员内部类的方法中，可以直接拿到当前外部类对象，格式是：外部类名.this。
    //3 默认情况下访问遵循：就近原则，方法内局部有就访问局部，局部没有访问本类成员，本类成员没有就范围外部类成员。
public class Demo1 {
    public static void main(String[] args) {
        //如何创建内部类对象：外部类名.内部类名 对象名=new 外部类(...).new 内部类(...);
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
    }
}

class Outer {
    public int a = 30;

    public void show() {

    }
    //成员内部类
    public  class Inner {

        public int a = 20;
        public void show() {
            int a = 10;
            System.out.println("内部类");
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Outer.this.a);
        }
    }
}