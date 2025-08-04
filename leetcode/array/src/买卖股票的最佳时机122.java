/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午2:38 */
public class 买卖股票的最佳时机122 {
    public static void main(String[] args) {

    }
    public static int maxProfit(int[] prices) {
        int max  =0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= minPrice) {
                max += prices[i] - minPrice;
            }
            minPrice = prices[i];
        }
        return max;
    }


    public static int maxProfit1(int[] prices) {
        int max  =0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
