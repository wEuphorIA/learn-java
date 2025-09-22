package day7api;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午7:24
 */
public class Practice4 {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生日日期（格式：1998年08月08日）：");

        String birthday = scanner.next();
        LocalDate parse = LocalDate.parse(birthday, formatter);
        LocalDate now = LocalDate.now();

        Period period = Period.between(parse, now);

        System.out.printf("距离生日那天间隔%d年%d月%d日", period.getYears(), period.getMonths(), period.getDays());
    }
}
