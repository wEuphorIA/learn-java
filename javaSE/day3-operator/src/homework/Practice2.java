package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:54
 */
public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int number = scanner.nextInt();
        String result = number % 2 == 0 && number >= 10 ? "符合要求" : "不符合要求";
        System.out.println( result);
    }
}
