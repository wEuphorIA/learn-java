package com.itheima.d1_extends_construct;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午2:58 */
public class People {
    private String name;
    private int age;
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
