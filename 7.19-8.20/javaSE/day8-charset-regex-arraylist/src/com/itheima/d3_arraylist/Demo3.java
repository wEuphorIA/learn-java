package com.itheima.d3_arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/30 下午4:55
 */

public class Demo3 {
    public static void main(String[] args) {
        //现在假如购物车中存储了如下这些商品：
        // Java入门,宁夏枸杞，黑枸杞，人字拖，特级枸杞，枸杞子。现在用户不想买枸杞了，选择了批量删除，请完成该需求。
        List<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        //stream流删除枸杞
        /*list =  list.stream().filter(s -> !s.contains("枸杞")).collect(Collectors.toList());
        System.out.println(list);*/
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).contains("枸杞")){
                 list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("枸杞")){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);

    }
}
