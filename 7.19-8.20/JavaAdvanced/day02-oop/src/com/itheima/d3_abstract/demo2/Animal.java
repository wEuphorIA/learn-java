package com.itheima.d3_abstract.demo2;
/*
    作为抽象父类使用
    注意实现：
        1 抽象类不能被创建对象，仅作为一种特殊的父类，规定子类必须要重写的方法。
        2 子类继承抽象类，这个类必须重写所有的抽象方法，否则这个类也必须是抽象类。
        3 普通类有的成员(成员变量、方法、构造器)，抽象类都可以有。
        4 抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类。
 */
public abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //需求：将来所有的Animal子类都必须重写eat方法
    public abstract void eat();
}
