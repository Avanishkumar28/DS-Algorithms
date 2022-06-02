package rapipay;

/**
 * 121. Best Time to Buy and Sell Stock
 *         https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class StockBuySell {
    public static int maxProfit(int[] stockPrice){
        if (stockPrice == null || stockPrice.length < 2)
            return 0;
        int maxProfit = 0;
        int maxProfitSoFar = maxProfit;
        int buy = stockPrice[0];
        for (int index = 1; index < stockPrice.length; index++){
            if (buy > stockPrice[index])
                buy = stockPrice[index];
            else{
                if (maxProfitSoFar < stockPrice[index]-buy)
                    maxProfitSoFar = stockPrice[index]-buy;
                maxProfit = Math.max(maxProfit, maxProfitSoFar);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] test1 = {7,1,5,3,6,4};
        System.out.println(maxProfit(test1)); //5
        int[] test2 = {7,6,4,3,1};
        System.out.println(maxProfit(test2)); //0
    }
}
