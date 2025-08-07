package com.itheima.d2_innerclass;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午12:05 */
public class Demo4 {
    public static void main(String[] args) {
        Swim teacher = new Swim() {
            @Override
            public void swimming() {
                System.out.println("老师在游泳");
            }
        };
        Swimming(teacher);

        Swimming(new Swim() {
            @Override
            public void swimming() {
                System.out.println("学生在游泳");
            }
        });

    }

    public static void Swimming(Swim s) {
        System.out.println("开始游泳");
        s.swimming();
        System.out.println("结束游泳");
    }
}

interface Swim {
    void swimming();
}