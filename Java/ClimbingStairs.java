/*
 * @author Xiao
 * LeetCode: Climbing Stairs
 * Description: You are climbing a stair case. It takes n steps to reach the 
 *              the top. Each time you can either climb 1 or 2 steps. In how
 *              many distinct ways can you climb to the top?
 * Idea: simple DP.
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int state[] = new int[n + 1];
        state[0] = 1;
        state[1] = 1;
        for (int i = 2; i <= n; i++) {
            state[i] = state[i - 1] + state[i - 2];
        }
        return state[n];
    }
}