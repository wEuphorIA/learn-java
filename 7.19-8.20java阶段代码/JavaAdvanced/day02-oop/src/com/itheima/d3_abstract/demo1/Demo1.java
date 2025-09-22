package com.itheima.d3_abstract.demo1;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 上午10:30 */
public class Demo1 {
    public static void main(String[] args) {
        //抽象类最主要的特点：抽象类不能创建对象，仅作为一种特殊的父类，让子类继承并实现
        new A() {
            @Override
            public void show1() {

            }
        };
        new B();
    }
}

//一个类继承抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类
class B extends A{
    @Override
    public void show1() {

    }
}
abstract class A{
    //抽象类中不一定要有抽象方法，有抽象方法的类必须是抽象类
    //类有的成员：成员变量、方法、构造器，抽象类都可以有。
    private int age;

    public A() {
    }

    public A(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("show...");
    }
    abstract public void show1();
}