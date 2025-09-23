package com.itheima.d3_abstract.demo2;

public class Demo {
    public static void main(String[] args) {
        // 1 抽象类不能被创建对象，仅作为一种特殊的父类，规定子类必须要重写的方法
        //创建动物对象
//        Animal a =new Animal();  //报错：抽象类不能被创建对象
//        Dog dog = new Dog();
        Animal dog = new Dog();  //多态的体现
        dog.setName("旺财");
        System.out.println(dog.getName());
        dog.eat();
    }
}
