/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/30 上午10:35
 */
public class 删除有序数组中的重复项26 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        if (nums.length == 0){
            return 0;
        }
        fast = 1;
        slow = 1;
        while (fast < nums.length){
            if (nums[slow-1] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
