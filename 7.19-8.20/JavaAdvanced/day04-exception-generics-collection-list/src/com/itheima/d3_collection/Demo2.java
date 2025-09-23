package com.itheima.d3_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.IntFunction;

/*
目标：演示Collection集合的通用方法。
    由于Collection是所有单列集合的根接口，所以Collection接口的方法，所有单列集合都能够使用
 */
public class Demo2 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();

        //public boolean add(E e) 把给定的对象添加到当前集合中
        c.add("张三");
        c.add("王五");
        c.add("赵六");
        System.out.println(c);

        //public void clear() 清空集合中所有的元素
        // c.clear();
        System.out.println(c);

        //public boolean remove(E e) 把给定的对象在当前集合中删除
         c.remove("张三");
         System.out.println(c);

        //public boolean contains(Object obj) 判断当前集合中是否包含给定的对象
        System.out.println(c.contains("王五"));

        //public boolean isEmpty() 判断当前集合是否为空
        System.out.println(c.isEmpty());

        //public int size() 返回集合中元素的个数。
         System.out.println(c.size());

        //public Object[] toArray() 把集合中的元素，存储到数组中
        Object[] arr = c.toArray();
        System.out.println(Arrays.toString(arr));

        String[] array = c.toArray(new String[0]);
        System.out.println(array);

        //强转：子类类型 变量名 = （子类类型）父类变量名
       String[] strings = new String[arr.length];
       for (int i = 0; i < arr.length; i++) {
           strings[i] = (String) arr[i];
       }
       System.out.println(Arrays.toString(strings));
       //借用toArray方法
       // String[] array1 = c.toArray( value -> new String[value]);
       String[] array1 = c.toArray(String[]::new);
       System.out.println(Arrays.toString(array1));

    }
}
