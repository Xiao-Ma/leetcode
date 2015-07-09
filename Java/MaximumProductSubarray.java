/**
 * @author Xiao
 * LeetCode: Maximum Product Subarray
 * Description: Find the contiguous subarray within an array (containing at 
 *              least one number) which has the largest product.
 * Idea: Notice negative number multiplies negative number will get positive.
 *       Keep the minimum product at the same time.
 */
 
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int m = 0;
        while (m < nums.length) {
        	if (nums[m] == 0) {
        		m++;
        	} else {
        		break;
        	}
        }
        if (m == nums.length) {
        	return 0;
        }
        int min = nums[m];
        int max = min;
        int result = max;
        for (int i = m+1; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (max == 0) {
                    max = nums[i];
                    min = nums[i];
                } else {
                    int tmp = max;
                    max = Math.max(Math.max(nums[i], nums[i] * max), nums[i] * min);
                    min = Math.min(Math.min(nums[i], nums[i] * tmp), nums[i] * min);
                }
            } else {
                max = 0;
                min = 0;
                if (result < 0) {
                    result = 0;
                }
            }	
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}