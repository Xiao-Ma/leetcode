/**
 * @author Xiao
 * LeetCode: Sqrt(x)
 * Description: Implement int sqrt(int x).
 * Idea: use long type to avoid overflow.
 */
 
public class Sqrt {
    public int mySqrt(int x) {
        if (x < 0) {
            return Integer.MIN_VALUE;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        long start = 0;
        long end = x / 2;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;
            if (square == x) {
                return (int)mid;
            } else if (square < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return (int)end;
        } else {
            return (int)start;
        }
    }
}