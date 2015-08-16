/**
 * @author Xiao
 * LeetCode: Product of Array Except Self
 * Description: Given an array of n integers where n > 1, nums, return an array
 *              output such that output[i] is equal to the product of all the
 *              elements of nums except nums[i]. Solve it without division and 
 *              in O(n).
 * Follow up: Could you solve it with constant space complexity?
 */
 
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] result = new int[len];
        left[0] = nums[0];
        for (int i = 1; i < len - 1; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        int cur = nums[len - 1]; //the right hand side of the *
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                result[i] = left[i - 1];
            } else if (i == 0) {
                result[i] = cur;
            } else {
                result[i] = left[i - 1] * cur;
                cur *= nums[i];
            }
        }
        return result;
    }
    /*Solution without extra space.*/
    public int[] productExceptSelfSol2(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[1] = nums[0];
        int cur = nums[len - 1];
        for (int i = 2; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i > 0; i--) {
            result[i] *= cur;
            cur *= nums[i];
        }
        result[0] = cur;
        return result;
    }
}