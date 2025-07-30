package day7api;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/23 下午6:26
 */
public class Practice3 {
    public static void main(String[] args) {
        String s = "20 30 33 55 66 88";
        String[] s1 = s.split(" ");
        int sum = 0;
        for (int i = 0; i < s1.length; i++){
            sum += Integer.parseInt(s1[i]);
        }
        System.out.println("这些数的和为" + sum);
        double avg = sum * 1.0 / s1.length;
        System.out.println( "这些数的平均值为" + String.format("%.2f", avg));
    }
}
