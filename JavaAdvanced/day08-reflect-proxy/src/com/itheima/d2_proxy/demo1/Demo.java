package com.itheima.d2_proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//目标：掌握动态代理的实现方式
public class Demo{
    public static void main(String[] args) {
        //1 创建目标对象(大明星)，也就是被代理对象
        BigStar bigStar=new BigStar();

        //2 创建代理对象(代理人)
        ClassLoader classLoader = bigStar.getClass().getClassLoader();
        Class<?>[] interfaces = {Star.class};
        Star proxyObj = (Star) Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("收首付款...");
                //反射调用目标对象bigStar的方法
                Object value = method.invoke(bigStar, args);
                System.out.println("收尾款...");
                return value;
            }
        });

        //3 调用代理对象（代理人）的方法
        String value1 = proxyObj.sing();
        //System.out.println(value1);

        System.out.println("----------------------");

        String value2 = proxyObj.dance();
        //System.out.println(value2);
    }
}
