/**
 * @author Xiao
 * LeetCode: Power of Two
 * Description: Given an integer, write a function to determine if it is a power
 *              of two.
 */
 
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 2) {
            int tmp = n >> 1;
            int diff = n - tmp;
            if (tmp != diff) {
                return false;
            }
            n = tmp;
        }
        return true;
    }
}