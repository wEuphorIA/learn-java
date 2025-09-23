package homework;

import java.util.Scanner;
/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 上午11:06
 */
public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个月份：");
        int month = scanner.nextInt();
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
        }
    }
}
