package com.itheima.d3_arraylist;
/*
    菜品类：
        菜品名称、菜品价格、菜品描述
 */
public class Dish {
    //1 私有的成员变量
    private String name;    //菜品名称
    private double price;   //菜品价格
    private String desc;    //菜品描述

    //2 构造器
    public Dish() {
    }
    public Dish(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    //3 生成set/get方法，toString方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
