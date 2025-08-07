import java.util.Iterator;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午9:03 */
//环形链表带哨兵
public class CircularDoublyLinkedList implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node {

        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel  = new Node(null, -1, null);

    public CircularDoublyLinkedList() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    //添加第一个
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }

    //添加最后一个
    public void addLast(int value) {
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;

    }

}
