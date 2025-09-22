package com.itheima.d4_list;

import java.util.LinkedList;

/**
 目标：掌握LinkedList集合的使用。
 LinkedList特有方法
 public void addFirst(E e)	在该列表开头插入指定的元素
 public void addLast(E e)	将指定的元素追加到此列表的末尾
 public E getFirst()	返回此列表中的第一个元素
 public E getLast()	返回此列表中的最后一个元素
 public E removeFirst()	从此列表中删除并返回第一个元素
 public E removeLast()	从此列表中删除并返回最后一个元素
 */
public class Demo2 {
    public static void main(String[] args) {

        // 1、创建一个队列。队列的特点，先进先出
        LinkedList<String> queue = new LinkedList<>();

        // 入队
        queue.addFirst("a");
        queue.addFirst("b");
        queue.addFirst("c");
        queue.addFirst("d");

        // 出队
        System.out.println(queue.removeLast());
        System.out.println(queue.removeLast());
        System.out.println(queue.removeLast());
        System.out.println(queue.removeLast());

        System.out.println("--------------------------------------------------");

        // 2、创建一个栈对象。栈的特点，先进后出
        LinkedList<String> stack = new LinkedList<>();

        // 压栈(push)
        stack.addFirst("1");
        stack.addFirst("2");
        stack.addFirst("3");
        stack.addFirst("4");

        // 出栈(pop)
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());

    }
}
