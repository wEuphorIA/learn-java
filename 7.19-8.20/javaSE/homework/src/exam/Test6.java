package exam;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 下午4:40 */
public class Test6 {
    public static void main(String[] args) {
        int[] arr = {171, 172, 19, 16, 117, 51, 210, 7, 718};
        int sum = 0;
        for (int num : arr) {
            if (num % 2 != 0 && !String.valueOf(num).contains("7")) {
                sum += num;
            }
        }
        System.out.println("符合条件元素的总和是:" + sum);
        short h = 1;
        h = (short) (h+1);
        System.out.println(h+1);

    }

}
