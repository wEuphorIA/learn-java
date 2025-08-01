package day3_stream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 上午9:55
 */

public class Practice1 {
    public static void main(String[] args) {
        String info = "helloworldjava";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < info.length(); i++) {
            char c = info.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        map.forEach((k, v) -> System.out.print(k + "-" + v + " "));
    }
}
