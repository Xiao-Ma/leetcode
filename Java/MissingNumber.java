/**
 * @author Xiao
 * LeetCode: Missing Number
 * Description: Given an array containing n distinct numbers taken from 0, 1, 2,
 *              ..., n, find the one that is missing from the array.
 * Idea: using the sum of n numbers minus the sum of array.
 */
 
public class MissingNumber {
    public int missingNumber(int[] nums) {int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        return len * (len + 1) / 2 - sum;
        
    }
}