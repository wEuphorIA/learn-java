package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:55
 */
public class Practice5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个四位数字：");
        int number = scanner.nextInt();
        int a = number / 1000;
        int b = number % 1000 / 100;
        int c = number % 100 / 10;
        int d = number % 10;
        System.out.println("个位：" + d);
        System.out.println("十位：" + c);
        System.out.println("百位：" + b);
        System.out.println("千位：" + a);
        int sum = a+b+c+d;
        System.out.println("个位、十位、百位、千位、数字之和" + sum);
    }
}
