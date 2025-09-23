package com.itheima.d3_lambda.demo1;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 下午4:16 */
// 目标:认识lambda表达式
// 作用:可以用于替代某些匿名内部类对象，从而让程序更简洁，可读性更好。
// 语法结构:  (被重写方法的形参列表)  -> {被重写方法的主体代码;}
// 注意事项:Lambda表达式只能替代函数式接口的匿名内部类！！！
public class Demo1 {
    public static void main(String[] args) {
        /* Swim teacher = new Swim() {
            @Override
            public void swimming() {
                System.out.println("老师在游泳");
            }
        }; */
        Swim teacher = () -> System.out.println("老师在游泳");

        teacher.swimming();
    }
}
//注意事项:Lambda表达式只能替代函数式接口的匿名内部类！！！
//functional interface 注解表示当前接口是函数式接口
//函数式接口：只有一个抽象方法
@FunctionalInterface
interface Swim{
    void swimming();
}