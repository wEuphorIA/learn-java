/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/2 上午1:40 */
public class 搜索插入位置35 {
    public static void main(String[] args) {

    }
    //java版本
    //查找到直接返回对应的索引
    //没有找到返回应该插入的索引
    public static int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i <= j){
            int mid = (i + j) >>> 1;
            if(target < nums[mid]){
                j = mid - 1;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else {
                return mid;
            }
        }
        return i;
    }

    public static int searchInsert1(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i <= j){
            int mid = (i+j) >>> 1;
            if(target <= nums[mid]){
                j = mid -1;
            }else {
                i = mid +1;
            }
        }
        return i;
    }
}
