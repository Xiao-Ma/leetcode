/**
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
    /**
     * Method of O(log(n)), use the method solving Fibonacci from sicp.
     * There is a transformation for a single step: 
     * newcur <- cur*p + next*q; newnext <- cur*q + next*p + next*q;
     * where p = 0, q = 1.
     * When we do two steps at one time, we find the same pattern only that
     * the p and q are changed: newp <- p^2 + q^2; newq <- q^2 + 2pq.
     */
    public int climbStairsSol2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        //int cur = 0;
        //int next = 1;
        //int cnt = n;
        //int p = 0; //p' = p^2 + q^2
        //int q = 1; //q' = q^2 + 2pq
        return fib(0, 1, 0, 1, n+1);
    }
    public int fib(int cur, int next, int p, int q, int cnt) {
        if (cnt == 0) {
            return cur;
        }
        if (cnt % 2 == 0) {
            int newp = p*p + q*q;
            int newq = q*q + 2*p*q;
            return fib(cur, next, newp, newq, cnt/2);
        } else {
            int newcur = cur * p + next * q;
            int newnext = cur * q + next * (p + q);
            return fib(newcur, newnext, p, q, cnt-1);
        }
    }
}