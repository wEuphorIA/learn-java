package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 下午7:55
 */
public class Practice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份：");
        int number = scanner.nextInt();
        if ( number % 4 == 0 && number % 100 != 0 || number % 400 == 0)
        {
            System.out.println(number + "是闰年");
        }else {
            System.out.println(number + "不是闰年");
        }
    }
}
