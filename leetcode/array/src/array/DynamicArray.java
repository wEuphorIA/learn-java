package array;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/2 上午2:25 */
// 动态数组
public class DynamicArray implements Iterable<Integer> {
    private int size = 0; // 存储数组中元素个数
    private int capacity = 8;// 存储数组的容量
    private int[] array = {};

    // 在数组末尾添加元素
    public void addLast(int element) {
        add(size, element);
    }

    // 在指定位置插入元素
    public void add(int index, int element) {
        checkAndGrow();
        // 添加逻辑
        if (index >= 0 && index <= size) {
            // 将index位置的元素向后移动一位
            System.arraycopy(array, index, array, index + 1, size - index);

        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        if (size == 0){
            array = new int[capacity];
        }
        // 容量检查
        if (size ==  capacity){
            //数组内元素已经放满了，要进行扩容1.5倍
            capacity +=  capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;

        }
    }

    //按索引查询 从0到size-1 左闭右开
    public int get(int index) {
        return array[index];
    }


    // 遍历方法一 实现Consumer接口
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    // 遍历方法二 实现Iterable接口 迭代器
    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            int i = 0;

            //遍历的时候询问有没有下个元素
            @Override
            public boolean hasNext() {
                return i < size;
            }

            //返回当前的元素，并让指针指向下个元素
            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    // 遍历方法三 使用stream流的方式进行遍历
    public IntStream stream() {
        return IntStream.of(array).limit(size);
    }


    //删除元素
    public int remove(int index) {
        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
        }
        size--;
        return removed;
    }
}
