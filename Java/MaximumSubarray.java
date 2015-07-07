/**
 * @author Xiao
 * LeetCode: Maximum Subarray
 * Description: Find the contiguous subarray within an array (containing at 
 *              least one number) which has the largest sum.
 * Idea:
 */
 
public class Maximum Subarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //max sum for subarray end with the index
        int[] sum = new int[nums.length]; 
        sum[0] = nums[0];
        int max = sum[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum[i - 1] < 0) {
                sum[i] = nums[i];
            } else {
                sum[i] = sum[i - 1] + nums[i];
            }
            if (sum[i] > max) {
                max = sum[i];
            }
        }
        return max;
    }
}