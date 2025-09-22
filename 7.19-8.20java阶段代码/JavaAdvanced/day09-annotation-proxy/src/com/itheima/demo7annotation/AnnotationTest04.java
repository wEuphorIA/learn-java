package com.itheima.demo7annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*

    目标：模拟junit单元测试
         解析这个类中的所有方法上的注解，如果加了注解的就调用这个方法，否则不调用
    需求:
        定义若干个方法，只要加了MyTest注解，就会触发该方法执行。
    分析:
        定义一个自定义注解MyTest，只能注解方法，存活范围是一直都在。
        定义若干个方法，部分方法加上@MyTest注解修饰，部分方法不加。
        模拟一个junit程序，可以触发加了@MyTest注解的方法执行。

 */
public class AnnotationTest04 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class cls = AnnotationTest04.class;
        AnnotationTest04 test04 = new AnnotationTest04();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                MyTest myTest = method.getDeclaredAnnotation(MyTest.class);
                for (int i = 0; i < myTest.value(); i++) {
                    method.invoke(test04);
                }
            }
        }

    }

    @MyTest
    public void test1() {
        System.out.println("测试方法1");
    }

    public void test2(){
        System.out.println("测试方法2");
    }
    @MyTest(5)
    public void test3(){
        System.out.println("测试方法3");
    }

    public void test4(){
        System.out.println("测试方法4");
    }
}
