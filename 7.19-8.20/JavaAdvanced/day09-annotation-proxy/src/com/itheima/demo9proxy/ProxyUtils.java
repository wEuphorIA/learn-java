package com.itheima.demo9proxy;

import java.lang.reflect.Proxy;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/19 下午4:19 */
public class ProxyUtils {
    public static <T> T getProxy(T t){
        T o = (T) Proxy.newProxyInstance(ProxyUtils.class.getClassLoader(), t.getClass().getInterfaces(), (proxy, method, args) -> {
            long start = System.currentTimeMillis();
            Object result = method.invoke(t, args);
            long end = System.currentTimeMillis();
            System.out.println("耗时："+(end-start)/1000.0+"秒");
            return result;
        });
        return o;
    }

}
