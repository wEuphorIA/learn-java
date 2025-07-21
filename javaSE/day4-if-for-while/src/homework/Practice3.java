package homework;

import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 上午11:06
 */
public class Practice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入作为程序员的你的工作的工龄:");
        int workAge = scanner.nextInt();
        System.out.println("请输入作为程序员的你的基本工资为:");
        int baseSalary = scanner.nextInt();

        if (workAge >= 10 && workAge < 15) {
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 20000,baseSalary + 20000
            );
        } else if (workAge >= 5 && workAge < 10) {
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 10000,baseSalary + 10000
            );
        } else if (workAge >= 3 && workAge < 5) {
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 5000,baseSalary + 5000
            );
        } else if (workAge >= 1 && workAge < 3){
            System.out.printf(
                    "您目前工作了%d年，基本工资为%d元, 应涨工资%d元,涨后工资%d元",workAge,
                    baseSalary, 3000 ,baseSalary + 3000
            );
        }
    }
}
