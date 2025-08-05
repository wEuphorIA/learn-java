import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午8:39 */

public class TestSinglelyLinkedList {

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
    }
}
