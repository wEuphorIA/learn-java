package day05.stream;

import java.util.HashMap;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/12 下午8:05 */
public class Practice3 {
    public static void main(String[] args) {
        String s = "helloworldjava";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // if (map.containsKey(c)){
            //     map.put(c,map.get(c)+1);
            // }else {
            //     map.put(c,1);
            // }
            map.put(c,map.getOrDefault(c,0)+1);
        }
        map.forEach((k,v)-> System.out.print(k + "=" + v +" "));
    }

}
