package homework.regular;

import java.util.ArrayList;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午8:27
 */
public class Practice1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("张") && list.get(i).length() == 3) {
                list1.add(list.get(i));
            }
        }
        System.out.println(list1);
    }
}
