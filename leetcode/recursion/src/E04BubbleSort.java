import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/8 下午7:00 */

public class E04BubbleSort {

    public static void sort(int[] nums) {
        bubble(nums, nums.length - 1);
    }

    // j 为未排序区域的右边界
    private static void bubble(int[] nums, int j) {
        if (j == 0) {
            return;
        }
        for (int i = 0; i < j; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
        bubble(nums, j - 1);
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1};
        bubble(nums, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
