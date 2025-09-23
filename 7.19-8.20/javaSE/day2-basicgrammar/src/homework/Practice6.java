package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:50
 */
public class Practice6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入小明左手中的纸牌：");
        int a = sc.nextInt();
        System.out.println("请输入小明右手中的纸牌：");
        int b = sc.nextInt();
        System.out.println("互换前小明手中的纸牌：");
        System.out.println("小明左手中的纸牌是：" + a);
        System.out.println("小明右手中的纸牌是：" + b);
        int c = a;
        a = b;
        b = c;
        System.out.println();
        System.out.println("互换后小明手中的纸牌：");
        System.out.println("小明左手中的纸牌是：" + a);
        System.out.println("小明右手中的纸牌是：" + b);
    }
}
