/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/29 下午12:18
 */
public class 移除元素27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int k = removeElement1(nums, val);
        System.out.println("k = " + k);
    }
    public static int removeElement(int[] nums, int val) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static int removeElement1(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
