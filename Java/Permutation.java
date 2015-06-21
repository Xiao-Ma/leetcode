/**
 * @author Xiao
 * LeetCode: Permutations
 * Description: Given a collection of numbers, return all possible permutations.
 * Idea: 1. insert numbers one by one (BFS) 2. DFS, and linear search would be
 *       enough for permutation problem when No. of numbers is not big.
 */
 
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(nums[0]);
        result.add(cur);
        for (int i = 1; i < nums.length; i++) {
            while (result.get(0).size() == i) {
                cur = result.get(0);
                for (int j = 0; j <= i; j++) {
                    cur.add(j, nums[i]);
                    result.add(new ArrayList<Integer>(cur));
                    cur.remove(j);
                }
                result.remove(0);
            }
        }
        return result;
    }
    public List<List<Integer>> permuteSol2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> cur = new ArrayList<Integer>();
        dfs(result, cur, nums);
        return result;
    }
    public void dfs(List<List<Integer>> r, List<Integer> c, int[] nums) {
        if (c.size() == nums.length) {
            r.add(new ArrayList<Integer>(c));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!c.contains(nums[i])) {
                c.add(nums[i]);
                dfs(r, c, nums);
                c.remove(c.size() - 1);
            }
        }
    }
}