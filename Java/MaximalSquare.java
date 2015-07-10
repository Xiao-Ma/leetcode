/**
 * @author Xiao
 * LeetCode: Maximal Square
 * Description: Given a 2D binary matrix filled with 0's and 1's, find the 
 *              largest square containing all 1's and return its AREA.
 * Idea: dp, take care of intersected squares.
 */
 
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] state = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                state[0][i] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){
                   if (j == 0) {
                       state[i][j] = 1;
                   } else if (state[i][j - 1] > 0 && state[i - 1][j] > 0) {
                       int tmp = Math.min(state[i][j - 1], state[i - 1][j]);
                       if (matrix[i - tmp][j - tmp] == '1') {
                           state[i][j] = tmp + 1;
                       } else {
                           state[i][j] = tmp;
                       }
                   } else {
                       state[i][j] = 1;
                   }
                }
                if (state[i][j] > max) {
                    max = state[i][j];
                }
            }
        }
        return max;
    }
}