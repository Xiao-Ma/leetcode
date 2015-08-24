/**
 * @author Xiao
 * LeetCode: Single Number III
 * Description: Given an array of numbers nums, in which exactly two elements 
 *              appear only once and all the other elements appear exactly 
 *              twice. Find the two elements that appear only once.
 * Note: The order of the result is not important.
 *       Your algorithm should run in linear runtime complexity. Could you 
 *       implement it using only constant space complexity?
 * Idea: XOR all numbers, there must be a 1. XOR all numbers with 1 on the same
 *       bit and 0 on the same bit.
 */
 
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) {
            return nums;
        }
        int[] result = new int[2];
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            r = r ^ nums[i];
        }
        r = r & (~(r - 1));
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & r) != 0) {
                result[0] = result[0]^nums[i];
            } else {
                result[1] = result[1]^nums[i];
            }
        }
        return result;
    }
}