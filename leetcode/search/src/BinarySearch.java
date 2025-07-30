/**
 @author Euphoria
 @version 1.0
 {@code @description:} TODO
 {@code @date} 2025/7/30 下午7:46 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int i = binarySearchBasic(nums, 5);
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

}
