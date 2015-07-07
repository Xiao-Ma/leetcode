/**
 * @author Xiao
 * LeetCode: Unique Paths
 * Description: A robot is located at the top-left corner of a m*n grid. The
 *              robot can only move either down or right at any point in time. 
 *              The robot is trying to reach the bottom-right corner of the 
 *              grid. How many possible unique paths are there?
 * Idea: DP
 */
 
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] state = new int[m][n];
        int col = 0;
        int row = 0;
        for (col = 0; col < n; col++) {
            state[0][col] = 1;
        }
        for (row = 1; row < m; row++) {
            for (col = 0; col < n; col++) {
                if (col == 0) {
                    state[row][col] = 1;
                } else {
                    state[row][col] = state[row - 1][col] + state[row][col - 1];
                }
            }
        }
        return state[m-1][n-1];
    }
}