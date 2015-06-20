/**
 * @author Xiao
 * LeetCode: Combination Sum
 * Description: Given a set of candidate numbers(C) and a target number (T)
 *              find all unique combinations in C where the candidate numbers
 *              sums to T.
 * Note: All numbers including target will be positive integers.
 *       Elements in a combination must be in non-descending order (allow
 *       duplicate numbers in one combination).
 *       The solution set must not contain duplicate combinations.
 */
 
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<Integer>();
        dfs(result, candidates, cur, 0, target);
        return result;
    }
    public void dfs(List<List<Integer>> r, int[] c, List<Integer> cur, int m, int diff) {
        if (diff < 0) {
            return;
        }
        if (diff == 0) {
            r.add(new ArrayList<Integer>(cur));
        }
        for (int i = m; i < c.length; i++) {
            cur.add(c[i]);
            dfs(r, c, cur, i+1, diff - c[i]);
            cur.remove(cur.size() - 1);
        }
    }
}