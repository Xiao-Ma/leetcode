/**
 * @author Xiao
 * LeetCode: Permutation Sequence
 * Description: The set [1,2,3...n] contains a total of n! unique permutations.
 *              By listing and labelling all of the permutations in ascending
 *              order. Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * Idea: 
 */

public class GetPermutation {
    public String getPermutation(int n, int k) {
        int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		if (k > fact || k <= 0) {
            return null;
        }
        List<Integer> s = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            s.add(i);
        }
        String result = "";
        int seq = k;
        int cnt = n - 1;
        fact /= n;
        while (seq > 1) {
            int num = (seq - 1) / fact;
            result = result.concat(String.valueOf(s.get(num)));
            s.remove(num);
            seq = seq % fact;
            fact /= cnt--;
        }
        if (seq == 1) { //all rest numbers in forwarding order
            for (int i = 0; i < s.size(); i++) {
                result = result.concat(String.valueOf(s.get(i)));
            }
        }
        if (seq == 0) { //all rest numbers in reverse order
            for (int i = s.size() - 1; i >= 0; i--) {
                result = result.concat(String.valueOf(s.get(i)));
            }
        }
        return result;
    }
    public int factorial(int x) {
        if (x == 0 || x == 1) {
            return 1;
        }
        int f = 1;
        for (int i = 2; i <= x; i++) {
            f *= i;
        }
        return f;
    }
    /**
     * Solution using recursion.
     */
    public String getPermutationSol2(int n, int k) {
        if (k > factorial(n) || k <= 0) {
            return null;
        }
        List<Integer> s = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            s.add(i);
        }
        String result = "";
        result = result.concat(getPermutationHelper(n - 1, k, s));
        return result;
    }
    public String getPermutationHelper(int n, int seq, List<Integer> l) {
        String r = "";
        if (seq == 1) {
            for (int i = 0; i < l.size(); i++) {
                r = r.concat(String.valueOf(l.get(i)));
            }
            return r;
        }
        if (seq == 0) {
            for(int i = l.size() - 1; i >= 0; i--) {
                r = r.concat(String.valueOf(l.get(i)));
            }
            return r;
        }
        int tmp = factorial(n);
        r = String.valueOf(l.remove((seq - 1) / tmp));
        return (r + getPermutationHelper(n - 1, seq % tmp, l));
    }
}