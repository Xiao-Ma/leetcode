/**
 * @author Xiao
 * LeetCode: Combination Sum II
 * Description: Given a set of candidate numbers(C) and a target number (T)
 *              find all unique combinations in C where the candidate numbers
 *              sums to T. Each number in C may only be used once.
 * Note: All numbers including target will be positive integers.
 *       Elements in a combination must be in non-descending order.
 *       The solution set must not contain duplicate combinations.
 * Idea: backtracking, similar to combination sum, notice that when a number
 * appears more than once may cause duplicate combinations. To avoid them,
 * similar to Subsets2, when backtracking skip the sequence of identical nums.
 */
 
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
    		while (i < c.length - 1 && c[i] == c[i+1]) {
                i++;
            }
    	}
    }
}