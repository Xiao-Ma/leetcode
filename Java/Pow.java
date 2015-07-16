/**
 * @author Xiao
 * LeetCode: pow(x, n)
 * Description: Implement pow(x, n).
 * Idea: corner case: n=-2147483648
 */
 
public class Pow {
    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            return Integer.MIN_VALUE;
        } else if (n == 0) {
            return 1;
        } else if (x == 0 || x == 1 || n == 1) {
            return x;
        }
        if (n > 0) {
            if (n % 2 == 0) {
                return myPow(x, n/2) * myPow(x, n/2);
            } else {
                return x * myPow(x, n - 1);
            }
        } else {
            return myPow(1/x, -n);
        }
        
    }
}