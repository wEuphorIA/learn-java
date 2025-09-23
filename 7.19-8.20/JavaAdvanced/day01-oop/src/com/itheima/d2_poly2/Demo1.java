package com.itheima.d2_poly2;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 上午11:14 */
public class Demo1 {
    public static void main(String[] args) {

        //多态的好处1:解耦合提高代码的扩展性
        Animal a1 = new Tortoise();
        show(a1);
        Animal a2 = new Wolf();
        show(a2);


    }
    //定义一个方法，可以接受任意类型动物，执行run方法
    //多态的好处2：形参类型写成父类型，这样方法可以接受任意子类对象提高代码的扩展性
    public static void show(Animal a){
        a.run();
    }
}
