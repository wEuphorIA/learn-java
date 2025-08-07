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
    //递归函数
    //针对某个节点要做的操作
    private void recursion(Node curr, Consumer<Integer> before, Consumer<Integer> after){
        if (curr == null){
            return;
        }
        before.accept(curr.data);
        recursion(curr.next, before, after);
        after.accept(curr.data);
    }
    //递归遍历
    public void loop2(Consumer<Integer> before,Consumer<Integer> after) {
        recursion(head,before,after);
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
    // public void test(){
    //     int i = 0;
    //     for (Node p = head; p != null; p = p.next){
    //         System.out.println(p.data + "索引是：" + i);
    //         i++;
    //     }
    // }

    //根据给定的索引位置找到节点
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null; //找不到返回null
    }

    //获取指定索引位置的元素
    public int get(int index) {
        Node node = findNode(index);
        if (node != null) {
            return node.data;
        } else {
            throw illegalIndex(index);
        }
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    /**
     @Description: 往链表中的任意位置加入元素
     @param: index
     @param: value
     @return: void
     @author Euphoria
     @date: 2025/8/5 上午10:18
     */
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) { // 上一个节点不存在
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);


    }

    /**
     @Description: 删除第一个元素
     @param:
     @return: void
     @author Euphoria
     @date: 2025/8/5 上午10:33
     */
    public void removeFirst() {
        if (head == null) {
            throw illegalIndex(0);
        }
        head = head.next;
    }

    /**
     根据指定的索引位置移除元素

     @param index 要移除元素的索引位置
     */
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node prev = findNode(index - 1); //获取前一个节点
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next; //被删除的节点
        if (removed == null) {
            throw illegalIndex(index);
        }
        prev.next = removed.next;
    }

}
