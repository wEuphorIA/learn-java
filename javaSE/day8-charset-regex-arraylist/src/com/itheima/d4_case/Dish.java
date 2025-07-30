package com.itheima.d4_case;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/30 下午5:35 */

public class Dish {

    private String name;

    private double price;

    private String desc;

    public Dish() {
    }

    public Dish(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

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

    @Override
    public String toString() {
        return "Dish{" +
                "desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
