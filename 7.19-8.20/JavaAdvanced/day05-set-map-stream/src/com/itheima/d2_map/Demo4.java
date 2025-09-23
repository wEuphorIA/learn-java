package com.itheima.d2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
需求
    某个班级80名学生，现在需要组织秋游活动，班长提供了四个景点依次是（A、B、C、D）,每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
分析：
    1 定义数组保存80名学生的投票结果：["C", "B", "A", "D", "B", "B", ...]
    String[] votes = {"C", "B", "A", "D", "B", "B", "D", "C", "D", "C", "A", "C", "A", "B", "C", "D", "A", "B", "A", "B", "B", "D", "A", "B", "D", "D", "C", "C", "D", "C", "B", "A", "C", "B", "D", "C", "B", "D", "B", "B", "B", "A", "B", "C", "B", "A", "C", "C", "B", "A", "A", "B", "B", "D", "B", "C", "A", "A", "D", "A", "D", "A", "C", "B", "B", "B", "A", "A", "D", "D", "C", "C", "D", "B", "B", "B", "D", "A", "C", "A"};
    2 定义一个Map集合用于存储统计的结果，Map<String，Integer>，键是景点(ABCD)，值代表投票数量。
    3 遍历数组，获取一个景点，判断Map集合中的键是否存在该景点，
    4 不存在存入“景点=1“。存在，获取原来的次数，+1后再存回去
    5 最后遍历打印集合中的投票结果。例如，打印结果如下：
        A=20
        B=20
        C=15
        D=25


 */
public class Demo4 {
    public static void main(String[] args) {
        String[] spots = {"钟楼","大雁塔","兵马俑","大唐不夜城"};
        ArrayList<String> strings = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            int index = random.nextInt(4);
            strings.add(spots[index]);
        }
        System.out.println(strings);
        HashMap<String, Integer> map = new HashMap<>();
        for (String spot : strings) {
            // if (!map.containsKey(spot)){
            //     map.put(spot,1);
            // }else {
            //     map.put(spot,(map.get(spot) + 1));
            // }
            // map.put(spot,map.containsKey(spot) ? map.get(spot) + 1 : 1);
            map.put(spot,map.getOrDefault(spot,0)+1);
        }
       map.forEach((k,v)-> System.out.println(k + "=" + v));
    }

}
