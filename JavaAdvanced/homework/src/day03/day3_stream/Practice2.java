package day3_stream;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 上午10:01
 */
public class Practice2 {
    public static void main(String[] args) {
        Integer[] arr = {123,456,777,345,345,222,999,222,110,120,567};
        //3.对元素按照降序排列
        //4.截取前面8个
        //5.跳过前面3个
        //6.去除重复元素
        //7.过滤保留偶数元素
        //8.遍历打印剩余元素
        Arrays.stream(arr).sorted((o1, o2) -> o2-o1).limit(8).skip(3)
                .distinct().filter(e -> e%2==0).forEach(System.out::println);
    }
}
