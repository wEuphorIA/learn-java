package exam;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 下午5:03 */
public class Test9 {
    public static void main(String[] args) {
        int sum = 0;
        //定义一个 int 类型的数组，
        int[] arr = {171, 172, 19, 16, 117, 51, 210, 7, 718};
        // 遍历数组筛选出元素为奇数且个位和十位都不包含 7 的元素，
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i] % 10 != 7 && arr[i] / 10 % 10 != 7) {
                System.out.println(arr[i]);
                sum += arr[i];
            }
            // 并求出符合条件的元素的总和

        }
        System.out.println("符合条件元素总和是:" + sum);
    }
}
