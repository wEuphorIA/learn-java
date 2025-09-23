package com.itheima.d3_reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
  目标:反射的基本作用
     1.基本作用：可以得到一个类的全部成分然后操作。
     2.可以破坏封装性。
     3.可以绕过泛型的约束

 */
public class Demo03 {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("I");
        list.add("am");
        list.add("learning");

        Class cls = list.getClass();
        Method add = cls.getMethod("add", Object.class);
        add.invoke(list, 185);
        System.out.println(list);
    }
}
