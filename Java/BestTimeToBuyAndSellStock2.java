/**
 *@Author Xiao Ma
 *LeetCode: Best Time to Buy and Sell Stock II
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *Find the maximum profit by completing as many transactions as you like.
 *You may not engage in multiple transactions at the same time.
 */.

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += (prices[i] - prices[i - 1]);
			}
		}
		return profit;
    }
}