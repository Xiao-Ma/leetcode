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
            while (result.get(0).size() == i) {
            	cur = result.get(0);
                for (int j = i; j >= 0; j--) {
            		if (j != i && cur.get(j) == nums[i]) {
            			break;
            		}
            		cur.add(j, nums[i]);
            		result.add(new ArrayList<Integer>(cur));
                    cur.remove(j);
            	}
                result.remove(0);
            }   
        }
        return result;
    }
}