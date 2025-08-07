import org.junit.Test;

import java.util.List;

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


}
