/**
 * @author Xiao
 * LeetCode: Combinations
 * Description: Given two integers n and k, return all possible combinations
 *            of k numbers out of 1...n.
 * Idea: backtracking, similar to subset except that only add list to result when
 *       its length is equal to k.
 */
 
 public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < k || k == 0) {
            return result;
        }
        List<Integer> cur = new ArrayList<Integer>();
        dfs(result, cur, n, 1, k);
        return result;
    }
    public void dfs(List<List<Integer>> r, List<Integer> c, int n, int m, int k) {
        if (c.size() >= k) {
            return;
        }
        for (int i = m; i <= n; i++) {
            c.add(i);
            if (c.size() == k) {
                r.add(new ArrayList<Integer>(c));
            }
            dfs(r, c, n, i+1, k);
            c.remove(c.size() - 1);
        }
    }
 }