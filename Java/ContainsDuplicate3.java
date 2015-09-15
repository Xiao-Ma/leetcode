/**
 * @author Xiao
 * LeetCode: Contains Duplicate III
 * Description: Given an array of integers, find out whether there are two 
 *              distinct indices i and j in the array such that the difference 
 *              between nums[i] and nums[j] is at most t and the difference 
 *              between i and j is at most k.
 * Idea: First try: brute force iterate over all i and j with j - i <= k. 
 *       Obviously, it will exceed time limit.
 */
 
public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < j + k && j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}