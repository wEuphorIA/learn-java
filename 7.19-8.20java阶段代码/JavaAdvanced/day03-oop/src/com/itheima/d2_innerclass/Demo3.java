package com.itheima.d2_innerclass;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 上午11:21 */
public class Demo3 {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            public void cry() {
                System.out.println("狗在叫");
            }
        };
        a.cry();

        Cat cat = new Cat();
        cat.show();

    }
}

class Cat {
    private String name = "猫";


    public void show() {
        String name = "黑马程序员";
        Animal a = new Animal() {
            @Override
            public void cry() {
                System.out.println("猫在叫");
                System.out.println(name);
                System.out.println(Cat.this.name);
            }
        };
        a.cry();
    }

}
