/**
 * @author Xiao
 * LeetCode: Range Sum Query - Immutable
 * Description: Given an integer array nums, find the sum of the elements 
 *              between indices i and j (i ≤ j), inclusive.
 *              You may assume that the array does not change.
 *              There are many calls to sumRange function.
 * Idea: See that the sumRange function will be called many times, if want to 
 *       save time, we can store all results, so each call will take O(1) time.
 *       A first thought is to pre-calculate all sumRange(i, j) and store them,
 *       that will take O(n^2) space.
 *       A better way is to store the cumulated sum in O(n), and get the range 
 *       by a minus operation.
 *       Here we have the thought of "cache".
 */
 
public class NumArray {
    private int[] nums;
    private int[] cumSums;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        this.cumSums = new int[nums.length];
        if (nums.length > 0) {
            this.cumSums[0] = this.nums[0];
            for (int i = 1; i < nums.length; i++) {
                cumSums[i] = cumSums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return cumSums[j];
        return cumSums[j] - cumSums[i - 1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);