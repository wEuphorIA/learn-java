import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Euphoria
 * @version 1.0
 * @description:
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @date 2025/7/30 上午10:59
 */
public class 多数元素169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(elementMost2(nums));
    }
    public static int elementMost(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2){
                return num;
            }
        }
        return -1;
    }

    public static int elementMost1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int elementMost2(int[] nums){
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
