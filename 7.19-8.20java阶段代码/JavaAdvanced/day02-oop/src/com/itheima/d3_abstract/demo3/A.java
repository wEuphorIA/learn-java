package com.itheima.d3_abstract.demo3;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 上午11:25 */
public abstract class A {
    //先写一个模板方法
    //模板方法要拿final修饰
    public final void write(){
        System.out.println("开始写代码...");
        writeCode();
        System.out.println("写代码结束...");
    }

    protected abstract void writeCode();
}
