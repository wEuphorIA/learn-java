package com.itheima;

import java.util.ArrayList;

public class OldDemo1 {
    public static void main(String[] args) {
        /*需求：
        现在假如购物车中存储了如下这些商品：Java入门,宁夏枸杞，黑枸杞，人字拖，特级枸杞，枸杞子。
        现在用户不想买枸杞了，选择了批量删除，请完成该需求*/

        // 1. 创建一个集合，存储商品
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        // 2. 遍历集合，获取每一个商品名称
        // 方式一:正向遍历,删除后索引减一
        /*for (int i = 0; i < list.size(); i++) {
            String goods = list.get(i);
            if(goods.contains("枸杞")){
                list.remove(goods);
                // 删除之后,索引-1
                i--;
            }
        }*/
        // 方式二: 倒序遍历,删除后索引不变
       /* for (int i = list.size() - 1; i >= 0; i--) {
            String goods = list.get(i);
            if(goods.contains("枸杞")){
                list.remove(goods);
            }
        }*/
        // 方式三:如果是正着遍历集合，在for循环的（）中不写i++，没有删除时i++；
        for (int i = 0; i < list.size(); ) {
            if (list.get(i).contains("枸杞")) {
                list.remove(i);
            } else {
                i++;
            }
        }
        // 3. 打印集合,查看结果
        System.out.println(list);
    }
}
