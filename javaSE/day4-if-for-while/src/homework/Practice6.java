package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 上午11:07
 */
public class Practice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个大于100的数:");
        int number = scanner.nextInt();
        int sum = 0;
        int j = 0;
        for (int i = 100; i <= number; i++) {
            if (i % 10 != 7 &&  i /10 % 10 != 5 && i / 100 != 3){
                System.out.println(i);
                sum += i;
                j++;
            }
        }
        System.out.println("和为：" + sum);
        System.out.println("个数为：" + j);
    }
}
