package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 上午11:07
 */
public class Practice5 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1000; i <= 9999; i++){
            if ((i % 10 + i / 1000) == (i / 10 % 10 + i /100 % 10) ){
                System.out.println(i);
                sum++;
            }
        }
        System.out.printf("以上满足条件的四位数总共有%d个：",sum);
    }
}
