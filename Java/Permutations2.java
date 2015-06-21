/**
 * @author Xiao
 * LeetCode: Permutations II
 * Description: Given a collection of numbers that might contain duplicates,
 *              return all possible unique permutations.
 * Idea: Sort array first, insert number one by one backwardly to the front
 *       or when meet the same number.
 */
 
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(nums[0]);
        result.add(new ArrayList<Integer>(cur));
        for (int i = 1; i < nums.length; i++) {
            cur = result.get(0);
            while (cur.size() < i) {
                for (int j = 0; j <= i; j++) {
                    while (j != 0 && cur.get(j) == nums[i]) {
                        j++;
                    }
                    cur.add(j, nums[i]);
                    result.add(new ArrayList<Integer>(cur));
                    cur.remove(j);
                }
            }
            result.remove(0);
        }
    }
}