import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 下午7:05
 */
/*给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
nums1 的初始长度为 m + n，其中前 m 个元素表
示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
*/
public class 合并数组88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 = {2, 5, 6};

        //merge(nums1, m, nums2, n);
        merge2(nums1, m, nums2, n);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++){
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int a = 0;
        int b = 0;
        int[] sort = new int[m + n];
        for (int i = 0; i < sort.length; i++) {
            // 处理nums1已遍历完的情况
            if (a == m) {
                sort[i] = nums2[b];
                b++;
            }
            // 处理nums2已遍历完的情况
            else if (b == n) {
                sort[i] = nums1[a];
                a++;
            } else if (nums1[a] < nums2[b]){
                sort[i] = nums1[a];
                a++;
            } else {
                sort[i] = nums2[b];
                b++;
            }
        }
        for (int i = 0; i < sort.length; i++) {
            nums1[i] = sort[i];
        }
        System.out.println(Arrays.toString(sort));
    }
}
