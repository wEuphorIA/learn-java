package com.itheima.single;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 上午9:41
 */
/**
         懒汉式：在类被加载的时候不创建对象，别人调用静态方法时再创建对象并返回。
             第一步：把类的构造器私有。
             第二步：定义一个静态变量用于保存该类的一个对象(暂时不new对象)。
             第三步：定义一个静态方法，在方法中判断并创建对象返回。
 */
public class B {

    private static B b;

    private B(){

    }
    public static B getInstance(){
        if(b == null){
            b = new B();
        }
        return b;
    }
}
