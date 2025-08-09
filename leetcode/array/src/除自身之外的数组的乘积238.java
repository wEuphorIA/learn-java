import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/8 下午6:02 */
public class 除自身之外的数组的乘积238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 计算前缀积（左侧乘积）
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 计算后缀积（右侧乘积）并合并结果
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }
}
