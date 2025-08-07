import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午9:17 */

public class TestCircularDoublyLinkedList {


    @Test
    public void addFirst() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertIterableEquals(List.of(4, 3, 2, 1), list);
    }

    @Test
    public void addLast() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        assertIterableEquals(List.of(1, 2, 3, 4), list);
    }

    @Test
    public void removeFirst() {
        CircularDoublyLinkedList list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2, 3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(3, 4), list);
        list.removeFirst();
        assertIterableEquals(List.of(4), list);
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    private CircularDoublyLinkedList getList() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }

    @Test
    public void removeLast() {
        CircularDoublyLinkedList list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1, 2, 3), list);
        list.removeLast();
        assertIterableEquals(List.of(1, 2), list);
        list.removeLast();
        assertIterableEquals(List.of(1), list);
        list.removeLast();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    @Test
    public void removeByValue() {
        CircularDoublyLinkedList list = getList();
        list.removeByValue(1);
        assertIterableEquals(List.of(2, 3, 4), list);
        list.removeByValue(4);
        assertIterableEquals(List.of(2, 3), list);
        list.removeByValue(3);
        assertIterableEquals(List.of(2), list);
        list.removeByValue(2);
        assertIterableEquals(List.of(), list);

    }
}
