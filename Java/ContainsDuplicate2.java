/**
 * @author Xiao
 * LeetCode: Contains Duplicate II
 * Description: Given an array of integers and an integer k, find out whether 
 *              there are two distinct indices i and j in the array such that 
 *              nums[i] = nums[j] and the difference between i and j is at most 
 *              k.
 */
 
public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) {
            return false;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (q.size() == k) {
                h.remove(q.offer());
            }
            q.poll(nums[i]);
                if (h.contains(nums[i])) {
                    return true;
                }
                h.add(nums[i]);
        }
        return false;
    }
}