package com.itheima.d1_extends_modifier;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午3:59 */
public class Fu {
    //private方法只能在本类中访问
    private void privateMethod(){

    }
    //默认方法 只能本类和本包下访问
    void defaultMethod(){

    }
    //protected方法 可以本类、本包、子类访问
    protected void protectedMethod(){

    }
    public void publicMethod(){

    }

    public void publicMethod(String name, int age){

    }
    public static void main(String[] args) {
        new Fu().publicMethod();
        new Fu().protectedMethod();
        new Fu().defaultMethod();
        new Fu().privateMethod();
    }
}
