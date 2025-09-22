package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:54
 */
public class Practice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = scanner.nextInt();
        number = number * number;
        System.out.println("该数平方是：" + number);
        number++;
        System.out.println("该数平方加1是：" + number);
    }
}
