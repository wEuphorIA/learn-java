package com.itheima.d3_lambda.demo6;

@FunctionalInterface
public interface CarFactory {
    Car create(String name);
}
