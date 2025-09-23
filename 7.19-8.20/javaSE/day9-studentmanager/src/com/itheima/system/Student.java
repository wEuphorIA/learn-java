package com.itheima.system;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 上午10:06 */
public class Student {

    private String id;

    private int age;

    private String name;

    private String address;

    public Student() {
    }

    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("%-12s%-8s%-5s%-18s",
                id, name, age, address);
    }
}
