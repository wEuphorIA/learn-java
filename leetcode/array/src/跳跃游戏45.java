/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 上午10:50 */
public class 跳跃游戏45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1){
            return 0;
        }
        int maxReach = nums[0]; // 当前能跳到的最远位置
        int steps = 1;         // 初始必须跳一次
        int end = nums[0];     // 当前跳跃的边界
        for (int i = 1; i < n; i++) {
            if (i == n - 1){
                return steps;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == end){
                steps++;
                end = maxReach;
            }
        }
        return steps;
    }
}
