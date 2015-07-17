/**
 * @author Xiao
 * LeetCode: Divide Two Integers
 * Description: Divide two integers without using multiplication, division and 
 *              mod operator. If it is overflow, return MAX_INT.
 * Note: For division, quotient is negative if one of dividend or divisor
 *       is negative, remainder is negative if the dividend is negative. But 
 *       they have the same absolute values regardless the sign of dividend and
 *       division. Consider using shift operation to compute multiply and divide
 *       by 2. Take care of -2147483648.
 */
 
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else if (dividend == 0) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (dividend == divisor) {
            return 1;
        } else if (dividend == -2147483648 && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (divisor == -1) {
            return -dividend;
        } else if (divisor == -2147483648) {
            return 0;
        }
        int n = Math.abs(divisor);
        boolean f = false;
        if (dividend == -2147483648) {
        	f = true;
        	dividend += n;
        }
        int m = Math.abs(dividend);
        if (m < n && f) {
        	if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
                return -1;
            } else {
                return 1;
            }
        } else if (m < n && !f) {
        	return 0;
        }
        int quotient = 0;
        int tmp = 1;
        int new_n = n;
        while (m > (new_n<<1) && (new_n<<1) > 0) {
            new_n <<= 1;
            tmp <<= 1;
        }
        quotient += tmp;
        int new_m = m - new_n;
        new_n >>= 1;
        tmp >>= 1;
        while (new_m >= n) {
            if (new_m < new_n && new_n > n) {
                new_n >>= 1;
                tmp >>= 1;
            } else {
                new_m -= new_n;
                quotient += tmp;
            }
        }
        if (f) {
        	quotient += 1;
        }
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            return -quotient;
        } else {
            return quotient;
        }
    }
}