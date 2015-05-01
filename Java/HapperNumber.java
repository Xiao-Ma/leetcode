/**
 * @author XIAO
 * LeetCode: Happy Number
 * Idea: if a number re-appears, there will be a loop.
 */

import java.util.Set;
import java.util.HashSet;
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<Integer>();
        s.add(n);
        int tmp = helper(n);
        while (tmp != 1) {
        	if (s.contains(tmp)) {
        		return false;
        	} else {
        		s.add(tmp);
        		tmp = helper(tmp);
        	}	
        }
		return true;
    }
    public int helper(int n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}
}