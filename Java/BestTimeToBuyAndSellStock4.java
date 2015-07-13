/**
 * @author Xiao
 * LeetCode: Best Time to Buy and Sell Stock IV
 * Description: Say you have an array for which the ith element is the price of 
 *              a given stock on day i. Design an algorithm to find the maximum 
 *              profit. You may complete at most k transactions. You may not 
 *              engage in multiple transactions at the same time (ie, you must 
 *              sell the stock before you buy again).
 * Idea: dp. Keep a local and global max profit.
 */
 
public class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k <= 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max += Math.max(prices[i] - prices[i - 1], 0);
            }
            return max;
        }
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                local[j] = Math.max(local[j] + prices[i] - prices[i - 1], global[j - 1]);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }
}