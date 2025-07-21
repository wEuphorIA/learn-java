package homework;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/21 上午11:06
 */
public class practice4 {
    public static void main(String[] args) {
        int sum =  0;
        for (int i = 1; i <= 100; i++){

            if (i % 3 == 0 && i % 5 == 0){
                sum += i;
                System.out.println(i);
            }

        }
        System.out.println("这些和为：" + sum);

    }
}
