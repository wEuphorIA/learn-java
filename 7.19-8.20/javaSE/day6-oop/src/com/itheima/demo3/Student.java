package com.itheima.demo3;



/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/27 下午12:15
 */
public class Student {

    //第一步：使用private关键字修饰成员变量，表示私有，外面就无法直接访问
    private String name;

    private int age;

    //第二步：给成员变量提供set和get方法来间接访问成员变量

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("年龄不合法");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
