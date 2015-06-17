/**
 * @author Xiao
 * LeetCode: Subsets II
 * Description: Given a collection of integers that might contain duplicates,
 *           return all possible subsets.
 * Note: Elements in a subset must be in non-descending order.
 *       The solution set must not contain duplicate subsets.
 * Idea: backtracking, when back tracking and getting a new number, skip the 
 *       same number which has just been moved out from list.
 */
 
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> sub = new ArrayList<Integer>();
        Arrays.sort(nums);
        result.add(sub);
        subsetHelper(result, nums, sub, 0);
        return result;
    }
    public void subsetHelper(List<List<Integer>> r, int[] n, List<Integer> s, int k) {
        for (int i = k; i < n.length; i++) {
            s.add(n[i]);
            r.add(new ArrayList<Integer>(s));
            subsetHelper(r, n, s, i + 1);
            s.remove(s.size() - 1);
            while (i < n.length - 1 && n[i] == n[i + 1]) {
                i++;
            }
        }
    }
}