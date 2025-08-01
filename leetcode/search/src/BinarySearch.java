/**
 @author Euphoria
 @version 1.0
 {@code @description:} TODO
 {@code @date} 2025/7/30 下午7:46 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 7, 8, 9, 10};

        int i = binarySearchRightMost2(nums, 6);
        System.out.println(i);

    }

    /**
     {@code @description:} 二分查找 基础版

     @param nums   数组
     @param target 目标值
     @author Euphoria
     date  2025/7/30 下午8:16
     */

    public static int binarySearchBasic(int[] nums, int target) {
        int left = 0, right = nums.length - 1; //设置指针和初始值
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                //如果目标值小于中间值，则将右边指针移到中间值的左边
                right = mid - 1;
            } else if (nums[mid] < target) {
                //如果目标值大于中间值，则将左边指针移到中间值的右边
                left = mid + 1;
            } else {
                //找到值
                System.out.println("找到目标值：" + target + "，索引为：" + mid);
                return mid;
            }
        }
        return -1;
    }

    //为什么写算法的时候while中的范围是left <= right而不是left < right？
    //因为left = right时，程序退出了while循环，直接返回了-1
    //（left+right） / 2 是不是有问题
    // 确实有问题需要改成右移符号
    public static int binarySearchBasicAlternative(int[] nums, int target) {
        int left = 0, right = nums.length; //第一处改动
        while (left < right) {             //第二处改动
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid ;              //第三处改动
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //找到值
                System.out.println("找到目标值：" + target + "，索引为：" + mid);
                return mid;
            }
        }
        return -1;
    }
    //leftMost
    //找到最左边的索引
    public static int binarySearchLeftMost1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int candidate = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //记录候选人
                candidate = mid;
                right = mid - 1;
            }
        }
        return candidate;
    }
    //rightMost
    //找到最右边的索引
    public static int binarySearchRightMost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int candidate = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //记录候选人
                candidate = mid;
                left = mid + 1;
            }
        }
        return candidate;
    }
    //二分查找
    //找到最左边的索引 返回值不同
    // return 返回的是 >= target 的最靠左的索引
    // 应用场景 求排名 求前任 leftMost(target) -1
    // 范围查询 < target (0,leftMost(target) -1)   >= (leftMost(target),无穷大)
    public static int binarySearchLeftMost2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //二分查找
    //找到最右边的索引 返回值不同
    // return 返回的是 <= target 的最靠右的索引
    // 求后任 求后任 rightMost(target) + 1
    // 范围查询 <= target (0,rightMost(target))  > (rightMost(target)+1,无穷大)
    //
    public static int binarySearchRightMost2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
