package com.itheima.d5_case;

import java.util.*;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/13 上午10:49 */
public class Room {
    private final List<Card> cards = new ArrayList<>();

    {
        System.out.println("创建房间");
        String[] colors = {"♥", "♠", "♣", "♦"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        Integer sorted = 0;
        for (String number : numbers) {
            for (String color : colors) {
                cards.add(new Card(color, number, sorted++));
            }
        }
        cards.add(new Card("小王", null, sorted++));
        cards.add(new Card("大王", null, sorted++));
    }

    public void start() {
        System.out.println("开始游戏");
        // 洗牌
        Collections.shuffle(cards);
        System.out.println(cards);

        // 发牌
        List<Card> p1 = new ArrayList<>();
        List<Card> p2 = new ArrayList<>();
        List<Card> p3 = new ArrayList<>();
        Map<String, List<Card>> map = new HashMap<>();
        map.put("玩家一", p1);
        map.put("玩家二", p2);
        map.put("玩家三", p3);

        for (int i = 0; i < cards.size() - 3; i++) {
            if (i % 3 == 0) p1.add(cards.get(i));
            else if (i % 3 == 1) p2.add(cards.get(i));
            else p3.add(cards.get(i));
        }
        // 验证每人是否17张
        System.out.println("玩家一牌数：" + p1.size()); // 应为17
        System.out.println("玩家二牌数：" + p2.size()); // 应为17
        System.out.println("玩家三牌数：" + p3.size()); // 应为17

        //底牌
        List<Card> bottom = cards.stream().skip(51).toList();
        System.out.println("底牌" + bottom);

        //玩家2抢牌
        p2.addAll(bottom);

        //排序
        p1.sort((o1, o2) -> o2.getSorted() - o1.getSorted());
        p2.sort((o1, o2) -> o2.getSorted() - o1.getSorted());
        p3.sort((o1, o2) -> o2.getSorted() - o1.getSorted());

        //看牌
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
