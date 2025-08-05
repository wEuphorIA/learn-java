package com.itheima.d2_poly;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 上午11:14 */
public class Demo1 {
    public static void main(String[] args) {
        //认识多态：父类引用指向子类对象
        Animal a1 = new Tortoise();
        a1.run();
        Animal a2 = new Wolf();
        a2.run();

    }
}
