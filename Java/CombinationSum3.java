/**
 * @author Xiao
 * LeetCode: Combination Sum III
 * Description: Find all possible combinations of k numbers that add up to add
 *              number n, given that only numbers from 1 to 9 can be used and
 *              each combination should be a unique set of numbers. Ensure that
 *              numbers within the set are sorted in ascending order.
 *Idea: backtracking, search a tree at depth of k with path sum equals to n.
 */
 
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0 || k > 9) {
            return result;
        }
        List<Integer> cur = new ArrayList<Integer>();
        dfs(result, cur, k, 1, n);
        return result;
    }
    public void dfs(List<List<Integer>> r, List<Integer> c, int k, int m, int diff) {
        if (diff < 0) {
            return;
        }
        if (c.size() >= k) {
            return;
        }
        for (int i = m; i < 10; i++) {
            c.add(i);
            if (c.size() == k && diff - i == 0) {
                r.add(new ArrayList<Integer>(c));
            }
            dfs(r, c, k, i + 1, diff - i);
            c.remove(c.size() - 1);
        }
    }
}