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
        if (k > factorial(n) || k <= 0) {
            return null;
        }
        List<Integer> s = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            s.add(i);
        }
        String result = "";
        int seq = k;
        int cnt = n - 1;
        while (seq > 1) {
            int tmp = factorial(cnt);
            int num = (seq - 1) / tmp;
            result = result.concat(String.valueOf(s.get(num)));
            s.remove(num);
            seq = seq % tmp;
            cnt--;
        }
        if (seq == 1) {
            for (int i = 0; i < s.size(); i++) {
                result = result.concat(String.valueOf(s.get(i)));
            }
        }
        if (seq == 0) {
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
}