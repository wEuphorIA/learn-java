package com.itheima.d4_interface.demo3;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午4:29 */
/*
    1、接口与接口可以多继承：一个接口可以同时继承多个接口[重点]。
    2、一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时不支持多继承，也不支持多实现。
    3、一个类继承了父类，又同时实现了接口，如果父类中和接口中有同名的默认方法，实现类会优先用父类的。
    4、一个类实现了多个接口，如果多个接口中存在同名的默认方法，可以不冲突，这个类重写该方法即可。
 */
public class Demo1 {
    public static void main(String[] args) {
        new C2().show();
    }
}

//1、接口与接口可以多继承：一个接口可以同时继承多个接口
//类和接口，多实现
//类和类，单继承
interface A {
}

interface B {
}

interface C extends A, B {
}

class D implements A, B, C {
}

//2、一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时不支持多继承，也不支持多实现。
interface A1 {
    void show();
}

interface B1 {
    String show();
}

//如果多个接口中存在方法签名冲突，则此时不支持多继承，也不支持多实现。
// interface C1 extends A1,B1{}
// class D1 implements A1,B1{}
//3、一个类继承了父类，又同时实现了接口，如果父类中和接口中有同名的默认方法，实现类会优先用父类的。
interface A2 {
    default void show() {
        System.out.println("A2.show()...");
    }
}
class B2 {
    public void show() {
        System.out.println("B2.show()...");
    }
}

class C2 extends B2 implements A2 {

}
//4、一个类实现了多个接口，如果多个接口中存在同名的默认方法，可以不冲突，这个类重写该方法即可。
interface A3 {
    default void show() {
        System.out.println("A3.show()...");
    }
}
interface B3 {
    default void show() {
        System.out.println("B3.show()...");
    }
}
class C3 implements A3, B3 {

    @Override
    public void show() {
        A3.super.show();
    }
}