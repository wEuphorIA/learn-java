/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/1 下午4:44 */
public class 买卖股票的最佳时机121 {
    public static void main(String[] args) {
        int [] prices = {1,2};
        System.out.println(maxProfit(prices));
    }
    //一次遍历
    public static int maxProfit(int[] prices) {
        int max  =0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else {
                max = Math.max(max, prices[i] - minPrice);
            }
        }
        return max;
    }
    //暴力搜索
    public int maxProfit1(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

}
