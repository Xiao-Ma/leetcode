/*
 * @author Xiao
 * LeetCode: Minimum Size Subarray Sum
 * Description: https://leetcode.com/problems/minimum-size-subarray-sum/
 *              Given an array of n positive integers and a positive integer s, 
 *              find the minimal length of a subarray of which the sum ¡Ý s.
 *              If there isn't one, return 0 instead.
 * Idea: use slide window, and record sum and minmum length.
 */

public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
        	return 0;
        }
        int start = 0;
        int end = 0;
        int sum = nums[0];
        int len = Integer.MAX_VALUE;
        while (end < nums.length && start <= end) {
            if (sum < s) {
                end++;
                if (end < nums.length) {
                    sum += nums[end];
                }
                continue;
            } else {
                if (len > end - start + 1) {
                    len = end - start + 1;
                }
                start ++;
                sum -= nums[start-1];
            }
        }
        if (len == Integer.MAX_VALUE) {
            return 0;
        }
        return len;
    }
}