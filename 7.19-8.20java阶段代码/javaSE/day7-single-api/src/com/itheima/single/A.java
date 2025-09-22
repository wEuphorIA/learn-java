package com.itheima.single;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 上午9:07
 */
/*
    设计模式：指的是一个问题通常有n中解决办法，最优的那种解决办法被人们总结出来了，就叫设计模式。
    单例设计模式：确保一个类只能创建一个对象，内存中也只有这一个对象。好处：减少内存的占用。
    分类：
        饿汉式：在类被加载的时候就创建对象，提供静态方法返回。
            第一步：把类的构造器私有。
            第二步：定义一个静态变量记住类的一个对象。
            第三步：定义一个静态方法，返回对象。
 */
public class A {

    // 第二步：定义一个静态变量记住类的一个对象。
    private static A a = new A();

    // 第一步：把类的构造器私有。
    private A(){

    }

    // 第三步：定义一个静态方法，返回对象。
    public static A getInstance(){
        return a;
    }
}
