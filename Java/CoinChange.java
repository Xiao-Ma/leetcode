/**
 * @author Xiao
 * LeetCode: Coin Change
 * Description: You are given coins of different denominations and a total 
 *              amount of money amount. Write a function to compute the fewest 
 *              number of coins that you need to make up that amount. If that 
 *              amount of money cannot be made up by any combination of the 
 *              coins, return -1.
 */
 
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] cnt = new int[amount + 1]; 
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount)
            cnt[coins[i]] = 1;
        }
        int i = 1;
        while (i <= amount) {
            if (cnt[i] > 0) {
                for (int j = 0; j < coins.length; j++) {
                    int tmp = i + coins[j];
                    if (tmp <= amount) {
                        if (cnt[tmp] == 0) {
                            cnt[tmp] = cnt[i] + 1;
                        } else {
                            cnt[tmp] = Math.min(cnt[tmp], cnt[i] + 1);
                        }
                    }
                }
            }
            i++;
        }
        if (cnt[amount] == 0) return -1;
        else return cnt[amount];
    }
    
    //recursive solution: will exceed time limit
    public int coinChange2(int[] coins, int amount) {
        return changeHelper(coins, amount, 0);
    }
    
    private int changeHelper(int[] coins, int amount, int n) {
        if (amount == 0) {
            return 0;
        } else if (n >= coins.length || coins[n] > amount) {
            return -1;
        }
        int left = changeHelper(coins, amount-coins[n], n);
        int right = changeHelper(coins, amount, n+1);
        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right;
        } else if (right == -1) {
            return left+1;
        } else {
            return Math.min(left+1, right);
        }
    }
}