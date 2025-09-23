package com.itheima.d2_innerclass;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/7 上午10:25 */
public class Demo2 {
    public static void main(String[] args) {
        // 创建静态内部类对象的格式: 外部类名.内部类名  变量名 = new 外部类名.内部类名();
        Outer1.Inner inner = new Outer1.Inner();
        inner.show();
    }
}
class Outer1 {
    public static int a = 30;
    public void show(){
        System.out.println("外部类方法");
        class Inner{
            public int a = 10;
            public void show(){
                System.out.println("局部内部类方法");
            }
        }
    }
    public static class Inner {

        public void show(){
            System.out.println("内部类方法");
            // 特点: 可以直接访问外部类的静态成员，不可以直接访问外部类的实例成员。
            System.out.println(a);
        }
    }
}
