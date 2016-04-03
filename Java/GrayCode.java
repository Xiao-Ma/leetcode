/**
 * @author Xiao
 * LeetCode: Gray Code
 * Description: The gray code is a binary numeral system where two successive 
 *              values differ in only one bit.
 *              Given a non-negative integer n representing the total number of 
 *              bits in the code, print the sequence of gray code. A gray code 
 *              sequence must begin with 0.
 * Idea: From Internet.. every time add a bit, reverse the sequence of previous 
 *       numbers, and add a "1" at the beginning of each number. Add those 
 *       numbers at last.
 */
 
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> r = new ArrayList<Integer>();
        r.add(0);
        if (n == 0) return r;
        r.add(1);
        if (n == 1) return r;
        for (int i = 1; i < n; i++) {
            int len = r.size();
            for (int j = len - 1; j >= 0; j--) {
                int tmp = r.get(j);
                r.add(tmp + (1<<i));
            }
        }
        return r;
    }
}