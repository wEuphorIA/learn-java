package day08.reflection;

import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午4:20 */
public class Test2 {
    public static void main(String[] args) {
        List<String> list = ProxyFactory.createArrayListProxy();

        // 测试各种操作
        list.add("张益达");
        list.add("张伟");
        list.set(1, "张大炮");
        String name = list.get(1);

        System.out.println("获取到的名字：" + name);
    }
}
