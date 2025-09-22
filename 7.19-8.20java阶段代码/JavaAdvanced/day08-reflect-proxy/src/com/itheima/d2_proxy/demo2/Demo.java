package com.itheima.d2_proxy.demo2;

//目标：掌握动态代理的实现方式
/*
动态代理开发步骤：
    1、定义接口(Star)，里面定义行为(sing和dance方法)，表示目标对象和代理对象都具有的功能。
    2、定义目标类(BigStart)实现Star接口，重写sing和dance方法，这个实现类的对象代表被代理的对象。
    3、定义一个测试类，在测试类创建目标对象，然后为其创建一个代理对象返回。（重点）
    4、代理对象中，首先需要输出”收首付款” ，然后调用目标对象方法唱歌和跳舞方法，最后输出”收尾款”。
    5、有了代理对象之后，调用代理对象的sing和dance方法，观察输出结果。

Proxy类获取动态代理对象：
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        参数一：类加载器，为代理对象生成class对象，从而产生代理对象。
        参数二：接口们，规定生成代理对象和目标对象要实现相同的接口，从而具有相同的功能。
        参数三：调用处理器，当调用代理对象方法时，该处理器就来处理代理逻辑。也就是用来定义代理对象要做的事。
        返回值：生成的代理对象。
InvocationHandler接口中的invoke方法：
    public Object invoke(Object proxy, Method method, Object[] args)
        参数一：代理对象。
        参数二：调用代理对象的方法。
        参数三：调用代理对象方法传递的参数值。
        返回值：哪里调用代理对象方法，此处的返回值就返回到哪里。
 */
public class Demo {
    public static void main(String[] args) {

    }
}
