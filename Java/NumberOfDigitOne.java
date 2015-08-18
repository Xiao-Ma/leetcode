/**
 * @author Xiao
 * LeetCode: Number of Digit One
 * Description: Given an integer n, count the total number of digit 1 appearing 
 *              in all non-negative integers less than or equal to n.
 */
 
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int result = 0;
        int m = 1;
        int i = 1;
        while (n > 0) {
            if (n % 10 == 1) {
                result += (n + 8) / 10 * i + m;
            } else {
                result += (n + 8) / 10 * i;
            }
            m += n % 10 * i;
            i *= 10;
            n /= 10;
        }
        return result;
    }
}