package com.itheima.d2_list;

import java.util.ArrayList;
import java.util.LinkedList;

/*
目标：ArrayList集合、LinkedList集合的底层原理（这里所说的原理，都是底层代码写好的，不需要我们自己写代码）
   ArrayList集合的底层原理：
        1 利用无参构造器创建的集合，会在底层创建一个默认长度为0的数组
        2 添加第一个元素时，底层会创建一个新的长度为10的数组
        3 再存储数据，如果此时数组已经存满了，会扩容1.5倍,将原数组中的元素复制到新数组中去，并将新数组作为ArrayList的容器。
        4 如果一次添加多个元素，1.5倍还放不下，则新创建数组的长度以实际为准。
        特点：由于ArrayList集合是数组实现，每次添加、删除元素时会涉及到数组的扩容，和元素的复制增删速度相对较慢

    2.LinkedList集合的底层原理：
        1 LinkedList集合是双向链表结构实现的，每一个元素就是链表中的一个节点，
        2 每一个节点包含三个部分，元素值、上一个节点地址、下一个节点地址
        3 当往LinkedList集合中添加元素时，实际上是往链表的尾结点位置添加一个新节点
        特点：由于LinkedList底层是链表结构，每次查询元素时要么从头往尾查，要么从尾往头查，所以查询较慢；增、删元素时，只需要重新设定节点地址就行，所以相对较快
 */
public class Demo2 {
    public static void main(String[] args) {
        //1 创建ArrayList集合，添加数据
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("脉劫");


        //2 创建LinkedList集合，添加数据
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("脉劫");

    }
}
