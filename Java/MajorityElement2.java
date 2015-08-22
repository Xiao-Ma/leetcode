/**
 * @author Xiao
 * LeetCode: Majority Element II
 * Description: Given an integer array of size n, find all elements that appear 
 *              more than n/3 times. The algorithm should run in linear time and
 *              in O(1) space.
 * Idea: Boyer-Moore Vote algorithm. Using "candidate" to mark candidates, and 
 *       "cnt" to mark the net extra votes for the candidates.
 *       There are two states for "candidate" -- the id (number); and null (not
 *       sure). When the new coming number is equal to one of the candidates, 
 *       the count for the candidate plus 1; else if one the the candidates is 
 *       in null state, assign this number to this candidate and set count as 1;
 *       else minus 1 from all counts and if the count become 0 the state of the
 *       corresponding candidate becomes null.
 *       At last check if the not null candidates have votes > n/3.
 */
 
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Integer candidate1 = null;
        int cnt1 = 0;
        Integer candidate2 = null;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (candidate1 != null && nums[i] == candidate1) {
                cnt1++;
            } else if (candidate2 != null && nums[i] == candidate2) {
                cnt2++;
            } else if (cnt1 == 0) {
                candidate1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                candidate2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                if (cnt1 == 0) {
                	candidate1 = null;
                }
                cnt2--;
                if (cnt2 == 0) {
                	candidate2 = null;
                }
            }
        }
        if (cnt1 > 0) {
            cnt1 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == candidate1) {
                    cnt1++;
                }
            }
            if (cnt1 > nums.length / 3) {
                result.add(candidate1);
            }
        }
        if (cnt2 > 0) {
            cnt2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == candidate2) {
                    cnt2++;
                }
            }
            if (cnt2 > nums.length / 3) {
                result.add(candidate2);
            }
        }
        return result;
    }
}