package com.itheima.d2_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
目标：演示Map集合的常用方法
 */
public class Demo2 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        //public V put(K key, V value) 添加/修改元素
        map.put("张三", 29);
        map.put("李四", 28);
        map.put("王五", 27);
        map.put("赵六", 26);
        map.put("王五", 33);

        //public int size() 获取集合的大小
        System.out.println(map.size());

        //public void clear() 清空集合
        map.clear();
        System.out.println(map);

        //public boolean isEmpty() 判断集合是否为空，为空返回true
        System.out.println(map.isEmpty());


        map.put("张三", 29);
        map.put("李四", 28);
        map.put("王五", 27);
        map.put("赵六", 26);
        //public V get(Object obj) 根据键获取对应值
        System.out.println(map.get("王五"));

        //public V remove(Object key) 根据键删除整个元素
        map.remove("王五");
        System.out.println(map);

        //public boolean containsKey(Object key) 判断是否包含某个键
        System.out.println(map.containsKey("王五"));

        //public boolean containsValue(Object key) 判断是否包含某个值
        System.out.println(map.containsValue(26));

        //public Set<K> keySet() 获取全部键的集合
        Set<String> names = map.keySet();
        System.out.println(names);

        //public Collection<V> values() 获取全部值的集合
        Collection<Integer> values = map.values();
        System.out.println(values);
    }
}
