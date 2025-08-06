package day08.reflection;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午4:20 */
public class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new ArrayListProxyHandler(target)
        );
    }

    public static List<String> createArrayListProxy() {
        return createProxy(new ArrayList<>());
    }
}
