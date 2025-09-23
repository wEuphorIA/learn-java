package com.itheima.demo8proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/19 下午3:40 */
public class ProxyUtils {
    public static BigStar getProxy(BigStarService target) {
        BigStar proxy = (BigStar) Proxy.newProxyInstance(ProxyUtils.class.getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("sing".equals(method.getName())){
                    System.out.println("准备话筒，收钱");
                }
                if ("dance".equals(method.getName())){
                    System.out.println("准备门票，收钱");
                }
                Object result = method.invoke(target, args);

                return result;
            }
        });

        return proxy;
    }
}
