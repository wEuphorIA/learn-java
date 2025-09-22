package com.itheima.d1_extends_construct;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 上午9:51 */
public class Demo2 {
    public static void main(String[] args) {
        Teacher t = new Teacher("赵敏", 18, "java");
        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getSkill());
    }
}
