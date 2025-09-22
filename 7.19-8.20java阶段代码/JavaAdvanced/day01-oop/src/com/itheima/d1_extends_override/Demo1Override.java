package com.itheima.d1_extends_override;

public class Demo1Override {
    // 目标:掌握重写的概念和使用
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.cry();

    }
}
class Aminal {
    public Object cry(){
        System.out.println("动物叫");
        return null;
    }
}
// 先子类局部范围找，然后子类成员范围找，然后父类成员范围找，如果父类范围还没有找到则报错。
class Dog extends Aminal {
    // 使用场景: 当子类觉得父类中的某个方法不好用，或者无法满足自己的需求时，可以重写父类方法;
    // 概念: 子类可以重写一个方法名称、参数列表一样的方法，去覆盖父类的这个方法，这就是方法重写;

    // 重写的小技巧: 添加一个@Override注解,保证方法名和参数列表一致,否则直接报错,保证代码安全性
    // 注意事项: 1. 子类重写父类方法时，访问权限必须大于或者等于父类该方法的权限（public〉protected〉缺省
    //          2. 重写的方法返回值类型，必须与被重写方法的返回值类型一样，或者范围更小。
    //          3. 私有方法、静态方法不能被重写，如果重写会报错的
    // 声明不变,重写实现
    @Override
    public Object cry() {
        System.out.println("汪汪汪");
        return null;
    }
}

