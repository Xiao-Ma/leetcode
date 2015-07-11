/**
 * @author Xiao
 * LeetCode: House Robber
 * Description: You are a professional robber planning to rob houses along a 
 *              street. Each house has a certain amount of money stashed, the 
 *              only constraint stopping you from robbing each of them is that 
 *              adjacent houses have security system connected and it will 
 *              automatically contact the police if two adjacent houses were 
 *              broken into on the same night. Given a list of non-negative 
 *              integers representing the amount of money of each house, 
 *              determine the maximum amount of money you can rob tonight 
 *              without alerting the police.
 * Idea: dp.
 */
 
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = nums[1];
        int max = Math.max(money[0], money[1]);
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                if (nums[i] + money[j] > money[i]) {
                    money[i] = nums[i] + money[j];
                }
            }
            if (money[i] > max) {
                max = money[i];
            }
        }
        return max;
    }
}