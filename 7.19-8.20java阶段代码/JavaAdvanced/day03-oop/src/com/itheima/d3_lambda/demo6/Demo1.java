package com.itheima.d3_lambda.demo6;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午6:18 */
// 场景: 如果某个Lambda表达式里只是在创建对象，并且"→"前后参数情况一致，就可以使用构造器引l用。
public class Demo1 {
    public static void main(String[] args) {
        //匿名内部类
        /* CarFactory factory = new CarFactory() {
            @Override
            public Car create(String name) {
                return new Car(name);
            }
        }; */

        //lambda表达式
        // CarFactory factory =  name -> new Car(name);
        //方法引用
        CarFactory factory = Car::new;
        Car c = factory.create("法拉利");
        System.out.println(c);
    }
}
