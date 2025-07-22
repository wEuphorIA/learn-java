package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 上午9:56
 */
public class main {
    public static void main(String[] args) {
        Practice practice = new Practice();

        System.out.println(practice.isLeapYear(2024));

        System.out.println(practice.isPrime(9));

        System.out.println("大写字母个数为" + practice.majusculeTotal("HelloWorld"));

        practice.total("Hello World! 123 你好。");
    }
}
