package com.itheima.d2_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/*
目标：演示Map集合的3种遍历方式
 */
public class Demo3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //public V put(K key, V value) 添加/修改元素
        map.put("张三", 29);
        map.put("李四", 28);
        map.put("王五", 27);
        map.put("赵六", 26);
        /*
            Map集合的遍历方式一：键找值
                public Set<K> keySet() 获取所有键的集合
                public V get(Object key) 根据键获取其对应的值
         */
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string + ":" + map.get(string));
        }
        System.out.println("------------------------------------------------");
        /*
        Map集合的遍历方式二：键值对
            Map集合提供的方法
                Set<Map.Entry<K, V>> entrySet() 获取所有“键值对”的集合
            Map.Entry对象提供的方法
                K  getKey() 获取键
                V  getValue() 获取值
         */
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        /*
        Map集合的遍历方式三：forEach()+lambda表达式
            default void forEach(BiConsumer<? super K, ? super V> action) 结合lambda遍历Map集合
         */
        System.out.println("------------------------------------------------");
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s + ":" + integer);
            }
        });

        System.out.println("------------------------------------------------");
        map.forEach((s, integer) -> System.out.println(s + ":" + integer));
    }
}
