package day8regular;

import java.util.ArrayList;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午8:31
 */
public class Practice2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("I");
        list.add("am");
        list.add("learning");
        list.add("Java");
        list.add("at");
        list.add("heima");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).toUpperCase() + " ");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
