/**
 * @author Xiao
 * LeetCode: Bitwise AND of Numbers Range
 * Description: Given a range [m, n] where 0 <= m <= n <= 2147483647, return the
 *              bitwise AND of all numbers in this range, inclusive. For example
 *              given the range [5, 7], you should return 4.
 * Idea: (from discuss) find the largest common left part of m and n. Numbers 
 *       between m and n will cover the rest right part with at least one 0 on
 *       each bit.
 */
 
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (m != n && m > 0){
            m = m >> 1;
            n = n >> 1;
            cnt++;
        }
        if (m == 0) {
            return 0;
        }
        return n << cnt;
    }
}