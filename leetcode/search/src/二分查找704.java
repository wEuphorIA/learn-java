/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/2 上午1:24 */
public class 二分查找704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
    }

    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (target < nums[mid]) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int search1(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = (i + j) >>> 1;
            if (target < nums[mid]) {
                j = mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //平衡板，缩小if判断的次数
    public static int search2(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i +1 < j) {
            int mid = (i + j) >>> 1;
            if (target < nums[mid]){
                j = mid;
            }else {
               i =mid;
            }
        }
        return (nums[i] == target ? i : -1);
    }
}
