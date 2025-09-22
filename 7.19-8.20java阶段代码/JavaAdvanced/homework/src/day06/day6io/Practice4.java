package day06.day6io;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/13 下午8:22 */
public class Practice4 {
    public static void main(String[] args) {
        getCount(10);
        int money = 10;
        int[] result = getCount1(money, money / 2, money / 2, money / 2);
        System.out.println(result[0] + "瓶水 " + result[1] + "瓶盖 " + result[2] + "瓶子");
    }

    private static void getCount(int n) {
        int price = 2;
        int total = n / price;
        int bottle = total;
        int cap = total;
        while (bottle >= 2 || cap >= 4) {
            if (cap >= 4) {
                int exchange = cap / 4;
                total += exchange;
                bottle += exchange;
                cap = cap % 4 + exchange;
            }
            if (bottle >= 2) {
                int exchange = bottle / 2;
                total += exchange;
                cap += exchange;
                bottle = bottle % 2 + exchange;
            }
        }
        System.out.println("喝了" + total + "啤酒");
        System.out.println("瓶盖还剩" + cap + "个");
        System.out.println("瓶子还剩" + bottle + "瓶");
    }

    private static int[] getCount1(int money, int total, int bottle, int cap){
        // 基本情况：无法继续兑换
        if (bottle < 2 && cap < 4) {
            return new int[]{total, bottle, cap};
        }

        // 优先用瓶盖兑换
        if (cap >= 4) {
            int exchange = cap / 4;
            return getCount1(money,
                    total + exchange,
                    bottle + exchange,
                    cap - 4 * exchange + exchange);
        }

        // 再用空瓶兑换
        if (bottle >= 2) {
            int exchange = bottle / 2;
            return getCount1(money,
                    total + exchange,
                    bottle - 2 * exchange + exchange,
                    cap + exchange);
        }

        return new int[]{total, bottle, cap};
    }
}

