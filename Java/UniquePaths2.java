/**
 * @author Xiao
 * LeetCode: Unique Paths II
 * Description: Follow up for "Unique Paths": Now consider if some obstacles are
 *              added to the grids. How many unique paths would there be? An
 *              obstacle and empty space is marked as 1 and 0 respectively in 
 *              the grid.
 * Idea: DP
 */
 
public class UniquePaths2 {
    public int uniquePathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] state = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (obstacleGrid[row][col] == 1) {
                    continue;
                } else if (row == 0 && col == 0) {
                    state[row][col] = 1;
                } else if (row == 0) {
                    state[row][col] = state[row][col - 1];
                } else if (col == 0) {
                    state[row][col] = state[row - 1][col];
                } else {
                    state[row][col] = state[row][col - 1] + state[row - 1][col];
                }
            }
        }
        return state[m - 1][n - 1];
    }
}