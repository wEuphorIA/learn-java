/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/8 下午6:40 */
//递归二分查找
public class E03BinarySearch {
    public static int search(int[] nums, int target) {
        return f(nums, target, 0, nums.length-1);
    }

     /**
     * 在有序数组中使用二分查找算法查找目标值
     * @param nums 有序数组
     * @param target 要查找的目标值
     * @param i 查找范围的起始索引
     * @param j 查找范围的结束索引
     * @return 目标值在数组中的索引，如果不存在则返回-1
     */
    private static int f(int[] nums, int target, int i, int j) {
        // 递归终止条件：查找范围无效
        if (i > j){
            return -1;
        }
        // 计算中间位置索引
        int m = (i + j) >>> 1;
        // 根据中间元素与目标值的大小关系，递归查找左半部分或右半部分
        if (target < nums[m]) {
            return f(nums, target, i, m-1);
        }else if (nums[m] < target){
            return f(nums, target, m+1, j);
        }else {
            return m;
        }
    }

}
