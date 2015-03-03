/**
 *@Author Xiao Ma
 *LeetCode: Best Time to Buy and Sell Stock
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *If you were only permitted to complete at most one transaction, find the maximum profit.
 */

public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int maxProf = Integer.MIN_VALUE;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			if ((prices[i] - minPrice) > maxProf) {
				maxProf = prices[i] - minPrice;
			}
		}
		return maxProf;
    }
}