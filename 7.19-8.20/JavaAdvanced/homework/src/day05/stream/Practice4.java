package day05.stream;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/12 下午8:09 */
// 3.对元素按照降序排列
// 4.截取前面8个
// 5.跳过前面3个
// 6.去除重复元素
// 7.过滤保留偶数元素
// 8.遍历打印剩余元素
public class Practice4 {
    public static void main(String[] args) {
        Integer[] arr = {123,456,777,345,345,222,999,222,110,120,567};
        Arrays.stream(arr).sorted((o1, o2) -> o2-o1).limit(8).skip(3)
                .distinct().filter(a -> a%2==0).forEach(System.out::println);
    }
}
