/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/7/31 上午9:01 */
public class 轮转数组189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate1(nums,k);
    }
    //使用额外的数组
    public static void rotate(int[] nums, int k) {
        int[]  Nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Nums[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(Nums,0,nums,0,nums.length);
    }

    //反转数组方法
    // 数组为 1，2，3，4，5，6，7
    // 一次反转为 7，6，5，4，3，2，1
    //
    public static void rotate1(int[] nums, int k) {
        k %= nums.length;//处理k大于数组长度的情况
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
