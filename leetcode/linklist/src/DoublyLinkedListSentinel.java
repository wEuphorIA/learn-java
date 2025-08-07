import java.util.Iterator;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午3:15 */
//双向链表带哨兵
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    static class Node {

        Node prev; //上一个节点指针
        int data;  //值
        Node next; //下一个节点指针

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head; // 头哨兵

    private Node tail; // 尾哨兵

    public DoublyLinkedListSentinel() {
        head = new Node(666, null, null);
        tail = new Node(999, null, null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (index == i) {
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        //创建节点 新的节点的上个指针指向上个节点，新节点的指针指向下个节点
        Node inserted = new Node(value, prev, next);
        //将前驱节点（prevNode）的next指针指向新节点（newNode）
        prev.next = inserted;
        //下个节点的上个指针指向新的节点
        next.prev = inserted;

    }

    public void remove(int index) {
        //获取要删除的节点的前一个节点
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        //获取要删除的节点
        Node removed = prev.next;
        if (removed == tail) {
            throw illegalIndex(index);
        }
        //获取要删除的节点的下一个节点
        Node next = removed.next;

        //将前驱节点（prevNode）的next指针指向下个节点（nextNode）
        prev.next = next;
        //将被删除节点的下一个节点的prev指针指向前驱节点（prevNode）
        next.prev = prev;
    }

    public void removeFirst(){
        remove(0);
    }

    public  void addLast(int value){
        Node last = tail.prev;
        Node added = new Node(value, last, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast(){
        Node removed = tail.prev;
        if (removed == head){
            throw illegalIndex(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    private static IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.data;
                p = p.next;
                return value ;
            }
        };
    }
}
