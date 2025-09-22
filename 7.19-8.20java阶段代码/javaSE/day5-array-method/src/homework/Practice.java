package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/22 上午9:19
 */
public class Practice {

    //判断闰年
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    // 判断是否是质数
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算字符串中大写字母的数量
     *
     * @param str 输入的字符串
     * @return 大写字母的数量
     */
    public int majusculeTotal(String str) {
        int count = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }
        return count;
    }
    /**
     * 统计字符串中的各类字符数量
     * 该方法将接收一个字符串作为输入，然后统计其中的字母、数字、空格和其他字符的数量
     * 最后，它将输出这些统计结果
     *
     * @param str 输入的字符串，将基于此字符串进行字符统计
     */
    public void total(String str) {
        int letters = 0;
        int number = 0;
        int other = 0;
        int space = 0;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                letters++;
            } else if (ch >= '0' && ch <= '9') {
                number++;
            } else if (ch == ' ') {
                space++;
            } else {
                other++;
            }
        }
        // 格式化输出结果
        System.out.println("英文字母个数: " + letters);
        System.out.println("空格个数: " + space);
        System.out.println("数字个数: " + number);
        System.out.println("其他字符个数: " + other);
    }
}
