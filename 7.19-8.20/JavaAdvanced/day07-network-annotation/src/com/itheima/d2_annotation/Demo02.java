package com.itheima.d2_annotation;

//目标：了解自定义注解以及元注解，能看懂就行
/**
 * 注解的定义格式：
 *      public @interface 注解名称 {
 *              public 属性类型 属性名() default 默认值 ;
 *      }
 *      1、属性可有可无，根据实际需求来定义。
 *      2、属性类型：Java支持的数据类型基本上都可以使用
 *      3、默认值可以定义也可以不定义，如果不指定默认值，那么使用该注解时就必须给这个属性赋值。
 * 特殊属性：value
 *      如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可
 * 元注解：修饰注解的注解
 * 主要的元注解有两个：
 *      @Target: 约束自定义注解只能在哪些地方使用
 *          TYPE，类，接口
 *          FIELD, 成员变量
 *          METHOD, 成员方法
 *          PARAMETER, 方法参数
 *          CONSTRUCTOR, 构造器
 *          LOCAL_VARIABLE, 局部变量
 *      @Retention：申明注解的生命周期
 *          SOURCE：注解只作用在源码阶段，生成的字节码文件中不存在
 *          CLASS：注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值.
 *          RUNTIME：注解作用在源码阶段，字节码文件阶段，运行阶段（开发常用）
 */
public class Demo02{

    private String name;

    public void show(){}

    public static void main(String[] args) {

    }
}
