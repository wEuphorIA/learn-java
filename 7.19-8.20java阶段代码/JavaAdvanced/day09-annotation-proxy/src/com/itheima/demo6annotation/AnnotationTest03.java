package com.itheima.demo6annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/*
    目标:解析注解
    指导思想：要解析谁上面的注解，就应该先拿到谁。
            比如要解析类上面的注解，则应该先获取该类的Class对象，再通过Class对象解析其上面的注解。
            比如要解析成员方法上的注解，则应该获取到该成员方法的Method对象，再通过Method对象解析其上面的注解。
            Class 、 Method 、 Field , Constructor、都实现了AnnotatedElement接口，它们都拥有解析注解的能力
    方法:
        public Annotation[] getDeclaredAnnotations()	获取当前对象上面的注解。
        public T getDeclaredAnnotation(Class<T> annotationClass)	获取指定的注解对象
        public boolean isAnnotationPresent(Class<Annotation> annotationClass)	判断当前对象上是否存在某个注解
 */
public class AnnotationTest03 {
    /*
        需求:①定义注解MyTest，要求如
                包含属性：String value()
                包含属性：double aaa()，默认值为 100
                包含属性：String[] bbb()
                限制注解使用的位置：类和成员方法上
                指定注解的有效范围：一直到运行时
            ②定义一个类叫：Demo，在类中定义一个test1方法，并在该类和其方法上使用MyTest4注解
            ③定义AnnotationTest3测试类，解析Demo类中的全部注解
     */
    @Test
    public void test1() {
        if (Demo.class.isAnnotationPresent(MyTest.class)){
            MyTest declaredAnnotation = Demo.class.getDeclaredAnnotation(MyTest.class);
            System.out.println(declaredAnnotation.value());
            System.out.println(declaredAnnotation.aaa());
            System.out.println(Arrays.toString(declaredAnnotation.bbb()));
        }
    }

    @Test
    public void test2() throws NoSuchMethodException {
        Class<Demo> cls = Demo.class;
        Method method = cls.getDeclaredMethod("test1");
        if (method.isAnnotationPresent(MyTest.class)){
            MyTest myTest = method.getDeclaredAnnotation(MyTest.class);
            System.out.println(myTest.value());
            System.out.println(myTest.aaa());
            System.out.println(Arrays.toString(myTest.bbb()));
        }
    }
}
