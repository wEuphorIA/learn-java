package com.itheima.d1_extends_feature;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午5:00 */
public class Demo2 {
    public static void main(String[] args) {
        // c fu = new c();
        // fu.show();

    }
}
// object 是所有类的父类
// 默认继承了object类
class Fu extends  Object{
    public void show()
    {
        System.out.println("父类方法");
    }
}