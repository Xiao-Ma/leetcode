/**
 * @author XIAO
 * LeetCode: Two Sum
 * Description: Given an array of integers and a target,
 * find two numbers such that they add up to a specific target number.
 * Return the two indices.
 * You may assume that each input would have exactly one solution.
 */

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rslt = new int[2];
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(nums[i]) && i != h.get(nums[i])) {
                rslt[1] = i;
                rslt[0] = h.get(nums[i]);
                break;
            } else {
                h.put(target - nums[i], i);
            }
        }
        return rslt;
    }
}