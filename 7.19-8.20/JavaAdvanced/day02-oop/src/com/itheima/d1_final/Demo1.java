package com.itheima.d1_final;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午5:15 */
public class Demo1 {

    //常量只能被赋值一次
    //命名规范：常量命名必须全部大写，单词之间用下划线隔开。
    public static final double PI = 3.14;

    //修饰成员变量：该变量有且仅能被赋值一次。没什么意义
    public final int age = 18;

    public static void main(String[] args) {
        final int age = 18;

        //修饰变量：该变量有且仅能被赋值一次。
        //age = 19;
        //在方法内部的局部变量
        show(20);

        //修饰变量：该变量有且仅能被赋值一次。
        //PI = 3.15;
        //final修饰基本类型的变量，变量存储的数据不能被改变。
        Demo1 demo1 = new Demo1();
        // demo1.age = 19;
        //final修饰引用类型的变量，变量存储的地址不能被改变，但地址所指向对象的内容是可以被改变的。
        final int[] arr = {1, 2, 3};
        arr[0] = 10;
        System.out.println(Arrays.toString( arr));



    }

    //修饰变量：该变量有且仅能被赋值一次。
    public static void show(final int age) {
        //修饰变量：该变量有且仅能被赋值一次。
        //在形参位置的局部变量
        //age = 10;
    }
}

final class A {

}

//修饰类：该类被称为最终类，特点是不能被继承了。
// class B extends A{
// }
class B {
    //修饰方法：该方法被称为最终方法，特点是不能被重写了。
    public final void show() {
        System.out.println("show...");
    }
}

class C extends B {
    //修饰方法：该方法被称为最终方法，特点是不能被重写了。
    // @Override
    // public void show(){
    //    System.out.println("show...");
    // }
}