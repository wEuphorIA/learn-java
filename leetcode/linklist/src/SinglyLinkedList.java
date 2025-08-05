import java.util.Iterator;
import java.util.function.Consumer;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午8:20 */
//单向链表
public class SinglyLinkedList implements Iterable<Integer> { //整体
    private Node head = null; //头指针

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;

            @Override
            public boolean hasNext() { //询问是否有下个元素
                return p != null;
            }

            @Override
            public Integer next() { //返回当前元素的值，并且让指针指向下个元素
                int val = p.data;
                p = p.next;
                return val;
            }
        };
    }

    //节点
    private static class Node {
        int data;   //数据
        Node next;  //指针

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addFirst(int value) {
        //1.链表为空的情况
        //head = new Node(value,null);
        //2.链表不为空的情况
        head = new Node(value, head);
    }

    public void loop(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.data);
            p = p.next;
        }
    }

    public void loop1(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.data);
        }
    }

    private Node findLast() {
        //空链表
        if (head == null) return null;
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    //尾插法
    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
        } else {
            last.next = new Node(value, null);
        }
    }

    //遍历的时候获取索引
    public void test(){
        int i = 0;
        for (Node p = head; p != null; p = p.next){
            i++;
            System.out.println(p.data + "索引是：" + i);
        }
    }
}
