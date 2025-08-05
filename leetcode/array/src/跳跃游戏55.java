/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 下午8:11 */
public class 跳跃游戏55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++){
            if (i > max){
                return false;
            }else {
                max = Math.max(max, i + nums[i]);
            }
            if (max >= n - 1){
                return true;
            }
        }
        return false;
    }
}
