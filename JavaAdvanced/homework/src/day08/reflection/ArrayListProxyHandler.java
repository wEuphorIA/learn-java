package day08.reflection;



import java.lang.reflect.InvocationHandler;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午4:18 */
public class ArrayListProxyHandler implements InvocationHandler {
    private final Object target;

    public ArrayListProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {
        // 记录方法开始调用日志
        LogUtil.logMethodStart(method.getName(), args);

        // 执行原始方法
        Object result = method.invoke(target, args);

        // 记录方法结束调用日志
        LogUtil.logMethodEnd(method.getName(), result);

        return result;
    }
}
