/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/30 上午10:13
 */
public class 移除元素80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        if (nums.length < 2){
            return nums.length;
        }
        fast = 2;
        slow = 2;
        while (fast < nums.length){
            if (nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
