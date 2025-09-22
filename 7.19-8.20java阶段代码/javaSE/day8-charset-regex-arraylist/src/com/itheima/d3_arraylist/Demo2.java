package com.itheima.d3_arraylist;

import java.util.ArrayList;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/30 下午4:15
 */
public class Demo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //public boolean add(E e)将指定的元素添加到此集合的末尾
        list.add("赵敏");
        list.add("小昭");
        list.add("周芷若");
        System.out.println(list);

        //public void add(int index,E element)在此集合中的指定位置插入指定的元素
        list.add(1,"灭绝");
        System.out.println(list);

        //public E get(int index)返回此列表中指定位置的元素
        System.out.println(list.get(1));

        //public int sizeO返回集合中的元素的个数
        System.out.println(list.size());

        //public E remove (int index)删除指定索引处的元素，返回被删除的元素
        System.out.println(list.remove(1));
        System.out.println(list);

        //public boolean remove (Object o)删除指定的元素，返回删除是否成功
        System.out.println(list.remove("灭绝"));
        System.out.println(list);

        //public E set(int index,E element)修改指定位置的元素，返回被修改的元素
        System.out.println(list.set(1,"小昭"));
        System.out.println(list);

        //快捷键：集合.fori或者 集合.forr遍历集合
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-----------------");

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }
}
