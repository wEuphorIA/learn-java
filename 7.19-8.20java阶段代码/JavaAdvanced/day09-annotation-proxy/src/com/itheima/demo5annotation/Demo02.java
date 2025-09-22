package com.itheima.demo5annotation;

/**
  元注解：修饰注解的注解
  主要的元注解有两个：
       @Target: 约束自定义注解只能在哪些地方使用
           TYPE，类，接口
           FIELD, 成员变量
           METHOD, 成员方法
           PARAMETER, 方法参数
           CONSTRUCTOR, 构造器
           LOCAL_VARIABLE, 局部变量
       @Retention：申明注解的生命周期
           SOURCE：注解只作用在源码阶段，生成的字节码文件中不存在
           CLASS：注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值.
           RUNTIME：注解作用在源码阶段，字节码文件阶段，运行阶段（开发常用）
 */
public class Demo02 {

    private String name;

    public void show(){}

    public static void main(String[] args) {

    }
}
