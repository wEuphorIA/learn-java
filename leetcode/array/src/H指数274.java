import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午7:34 */
public class H指数274 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort( citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}
