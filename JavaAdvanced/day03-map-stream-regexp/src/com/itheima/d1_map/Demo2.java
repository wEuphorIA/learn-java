package com.itheima.d1_map;

/*
目标：演示Map集合的3种遍历方式
 */
public class Demo2 {
    public static void main(String[] args) {
        /*
            Map集合的遍历方式一：键找值
                public Set<K> keySet() 获取所有键的集合
                public V get(Object key) 根据键获取其对应的值
         */

        /*
        Map集合的遍历方式二：键值对
            Map集合提供的方法
                Set<Map.Entry<K, V>> entrySet() 获取所有“键值对”的集合
            Map.Entry对象提供的方法
                K  getKey() 获取键
                V  getValue() 获取值
         */

        /*
        Map集合的遍历方式三：forEach()+lambda表达式
            default void forEach(BiConsumer<? super K, ? super V> action) 结合lambda遍历Map集合
         */

    }
}
