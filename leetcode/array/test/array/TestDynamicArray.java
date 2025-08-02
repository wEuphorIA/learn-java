package array;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestDynamicArray {

    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

       // dynamicArray.add(2, 5);
        for (int i = 0; i < 5; i++){
            System.out.println(dynamicArray.get(i));
        }
    }
    @Test
    @DisplayName("测试遍历1")
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.forEach(System.out::println);
    }

    @Test
    @DisplayName("测试遍历2")
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        for (Integer integer : dynamicArray) {
            System.out.println(integer);
        }
    }

    @Test
    @DisplayName("测试遍历3")
    public void test4() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("测试删除")
    public void test5() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        // System.out.println(remove);
        // for (Integer integer : dynamicArray) {
        //     System.out.println(integer);
        // }
        int remove = dynamicArray.remove(2);
        assertEquals(3,remove);
        assertIterableEquals(List.of(1, 2, 4, 5),dynamicArray);
    }

    @Test
    @DisplayName("测试动态数组扩容")
    public void test6() {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++){
            dynamicArray.addLast(i+1);
        }
        assertIterableEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9),dynamicArray);
    }
}
