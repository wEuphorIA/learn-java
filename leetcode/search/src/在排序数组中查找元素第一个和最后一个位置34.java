import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/2 上午1:55 */
public class 在排序数组中查找元素第一个和最后一个位置34 {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int[] ints = searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] searchRange(int[] nums, int target) {
        // int left = left(nums, target);
        // if (left == -1){
        //     return new int[]{-1, -1};
        // }
        // int right = right(nums, target);
        // return new int[]{left, right};
        int x = binarySearchBound(nums, target, true);
        if (x == -1){
            return new int[]{-1, -1};
        }else {
            int y = binarySearchBound(nums, target, false);
            return new int[]{x, y};
        }
    }
    public static int left(int[] nums, int target){
        int i = 0, j = nums.length-1;
        int candidate = -1;
        while (i <= j){
            int mid = (i + j) >>> 1;
            if(target < nums[mid]){
                j = mid - 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else {
                candidate = mid;
                j = mid - 1;
            }
        }
        return candidate;
    }
    public static int right(int[] nums, int target){
        int i = 0, j = nums.length-1;
        int candidate = -1;
        while (i <= j){
            int mid = (i + j) >>> 1;
            if(target < nums[mid]){
                j = mid - 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else {
                candidate = mid;
                i = mid + 1;
            }
        }
        return candidate;
    }

    public static int binarySearchBound(int[] nums, int target, boolean findLeft) {
        int left = 0, right = nums.length - 1;
        int candidate = -1;

        while (left <= right) {
            int mid = (left + right) >>> 1;  // 无符号右移防止溢出

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 找到目标值后，根据方向决定收缩哪边
                candidate = mid;
                if (findLeft) {
                    right = mid - 1;  // 继续向左找第一个
                } else {
                    left = mid + 1;   // 继续向右找最后一个
                }
            }
        }
        return candidate;
    }
}
