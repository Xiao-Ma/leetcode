/**
 * @author Xiao
 * LeetCode: House Robber II
 * Description: This is an extension of House Robber. After robbing those houses
 *              on that street, the thief has found himself a new place for his 
 *              thievery so that he will not get too much attention. This time, 
 *              all houses at this place are arranged in a circle. That means 
 *              the first house is the neighbor of the last one. Meanwhile, the 
 *              security system for these houses remain the same as for those in
 *              the previous street. Given a list of non-negative integers 
 *              representing the amount of money of each house, determine the 
 *              maximum amount of money you can rob tonight without alerting the
 *              police.
 * Idea: dp. Two situations, rob first or rob last.
 */
 
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return max;
        }
        int[] m1 = new int[nums.length - 1];
        m1[0] = nums[0];
        m1[1] = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (nums[i] + m1[j] > m1[i]) {
                    m1[i] = nums[i] + m1[j];
                }
            }
            if (m1[i] > max) {
                max = m1[i];
            }
        }
        int[] m2 = new int[nums.length - 1];
        m2[0] = nums[1];
        m2[1] = nums[2];
        for (int i = 2; i < nums.length - 1; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (nums[i + 1] + m2[j] > m2[i]) {
                    m2[i] = nums[i + 1] + m2[j];
                }
            }
            if (m2[i] > max) {
                max = m2[i];
            }
        }
        return max;
    }
}