/**
 * @author Xiao
 * LeetCode: Minimum Path Sum
 * Description: Given a m x n grid filled with non-negative numbers, find a path
 *              from top left to bottom right which minimizes the sum of all 
 *              numbers along its path. You can only move either down or right.
 */
 
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] sum = new int[grid.length][grid[0].length];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + grid[i][j];
                } else {
                    sum[i][j] = grid[i][j] + 
                    (sum[i - 1][j] < sum[i][j - 1] ? sum[i - 1][j] : sum[i][j - 1]);
                }
            }
        }
        return sum[grid.length - 1][grid[0].length - 1];
    }
}