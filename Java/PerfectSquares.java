/**
 * @author Xiao
 * LeetCode: Perfect Squares
 * Description: Given a positive integer n, find the least number of perfect 
 *              square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *              For example, given n = 12, return 3 because 12 = 4 + 4 + 4; 
 *              given n = 13, return 2 because 13 = 4 + 9.
 * Idea: First Idea: Use recursive method similar to change coins -- will takes
 *       a long time even for not too big integers.
 */
 
public class PerfectSquares {
    /*Recursive.*/
    public int numSquares(int n) {
        if (n == 1) return 1;
        int len = (int)Math.floor(Math.sqrt(n));
        int[] sq = new int[len];
        for (int i = 0; i < len; i++) {
            sq[i] = (i + 1) * (i + 1);
        }
        return helper(sq, len, n);
    }
    private int helper(int[] sq, int cur, int rest) {
        if (rest < 0 || cur <= 0) {
            return Integer.MAX_VALUE - 1;
        } else if (rest == 0) {
            return 0;
        } else {
            return Math.min(helper(sq, cur - 1, rest), helper(sq, cur, rest - sq[cur - 1]) + 1);
        }
    }
    /*DP.*/
    public int numSquaresSol2(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        if (isSquareNumber(n)) {
            return 1;
        }
        int[] num = new int[n];
        num[0] = 1;
        num[1] = 2;
        num[2] = 3;
        for (int i = 3; i < n; i++) {
            if (isSquareNumber(i + 1)) {
                num[i] = 1;
                continue;
            }
            int tmp = Integer.MAX_VALUE;
            for (int p = 0, q = i - 1; p <= q; p++, q--) {
                tmp = Math.min(num[p] + num[q], tmp);
            }
            num[i] = tmp;
        }
        return num[n - 1];
    }
    private boolean isSquareNumber(int n) {
        int x = (int)Math.floor(Math.sqrt(n));
        if (x * x == n) {
            return true;
        } else {
            return false;
        }
    }
}