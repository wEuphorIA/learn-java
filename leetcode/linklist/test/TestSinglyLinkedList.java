import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午8:39 */

public class TestSinglyLinkedList {

    @Test
    @DisplayName("测试单链表")
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop1(System.out::println);
    }

    @Test
    @DisplayName("测试单链表")
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    @DisplayName("测试单链表")
    public void test3() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        for (Integer integer : list) {
            System.out.println(integer);
        }
        Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    @DisplayName("测试单链表")
    public void test4() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        // list.test();
        int i = list.get(10);
        System.out.println(i);
    }

    @Test
    @DisplayName("测试insert")
    public void test5() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.insert(5, 5);
        for (int i : list) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("测试removeFirst")
    public void test6() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.removeFirst();
        for (int i : list) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("测试remove")
    public void test7() {
        // SinglyLinkedList list = new SinglyLinkedList();
        // list.addLast(1);
        // list.addLast(2);
        // list.addLast(3);
        // list.addLast(4);
        // list.remove(2);
        // for (Integer integer : list) {
        //     System.out.println(integer);
        // }
        // System.out.println("=================");
        // SinglyLinkedList list1 = new SinglyLinkedList();
        // list1.addLast(1);
        // list1.addLast(2);
        // list1.addLast(3);
        // list1.addLast(4);
        // list1.remove(0);
        // for (Integer integer : list1) {
        //     System.out.println(integer);
        // }
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.remove(3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void testLoop() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.loop2(value -> System.out.println("before:" + value)
                , value -> System.out.println("after:" + value));
    }
}
