package com.itheima.demo4annotation;
/*
  注解的定义格式：
       public @interface 注解名称 {
               public 属性类型 属性名() default 默认值 ;
       }
       1、属性可有可无，根据实际需求来定义。
       2、属性类型：Java支持的数据类型基本上都可以使用
       3、默认值可以定义也可以不定义，如果不指定默认值，那么使用该注解时就必须给这个属性赋值。
  特殊属性：value
       如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可
  注解本质是一个接口，Java中所有注解都是继承了Annotation接口的。
          @注解(…)：其实就是一个实现类对象，实现了该注解以及Annotation接口
 */
public class Demo01 {

}
