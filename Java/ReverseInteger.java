/**
 * @author XIAO
 * LeetCode: Reverse Integer
 * Description:
 */

public class ReverseInteger {
    public int reverse(int x) {
        int tmp = x;
	long result = tmp % 10;
        while (tmp >= 10 || tmp <= -10) {
        	tmp /= 10;
        	result = result * 10 + tmp % 10;
        }
        if (result >> 31 > 0 && x > 0) {
        	return 0;
        } else if (x < 0 && (result >> 31 & 1) == 0) {
        	return 0;
        }
        return (int)result;
    }
}

/**
 * Note:
 * corner case: 0, -100, and those cause overflow.
 * Used long to perserve result and decide whether it will overflow on 32bit.
 */