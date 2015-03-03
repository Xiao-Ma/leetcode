/**
 *@Author Xiao Ma
 *LeetCode: Best Time to Buy and Sell Stock III
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int[] max1 = new int[prices.length];
		//int[] max2 = new int[prices.length];
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			if (i == 0) {
			    max1[0] = 0;
			    continue;
			}
			if ((prices[i] - minPrice) > max1[i - 1]) {
				max1[i] = prices[i] - minPrice;  
			} else {
			    max1[i] = max1[i - 1];
			}
		}
		int max = max1[max1.length - 1];
		if (max == 0) {
		    return 0;
		}
		int maxPrice = Integer.MIN_VALUE;
		for (int i = prices.length - 1; i > 0; i--) {
			if (prices[i] > maxPrice) {
				maxPrice = prices[i];
			}
			if ((maxPrice - prices[i] + max1[i - 1]) > max) {
				max = maxPrice - prices[i] + max1[i - 1];
			}
		}
		return max;
    }
}