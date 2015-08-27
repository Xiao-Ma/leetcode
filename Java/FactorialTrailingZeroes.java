/**
 * @author Xiao
 * LeetCode: Factorial Trailing Zeroes
 * Description: Given an integer n, return the number of trailing zeroes in n!.
 *              Your solution should be in logarithmic time complexity.
 * Note: i could overflow.
 */
 
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        long i = 5;
        int result = 0;
        while (i <= n) {
            result += n / 5;
            i *= 5;
        }
        return result;
    }
}