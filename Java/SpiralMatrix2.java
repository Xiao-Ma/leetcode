/**
 * @author Xiao
 * LeetCode: Spiral Matrix II
 * Description: Given an integer n, generate a square matrix filled with 
 *              elements from 1 to n2 in spiral order.
 *              For example, given n=3, you should return the following matrix:
 *              [[ 1, 2, 3 ],
 *               [ 8, 9, 4 ],
 *               [ 7, 6, 5 ]]
 */
 
public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) return result;
        int layer = 0;
        int cnt = 1;
        while (layer <= (n - 1) / 2) {
            for (int i = layer; i < n - 1 - layer; i++) {
                result[layer][i] = cnt++;
            }
            for (int i = layer; i < n - 1 - layer; i++) {
                result[i][n - 1 - layer] = cnt++;
            }
            for (int i = n - 1 - layer; i > layer; i--) {
                result[n - 1 - layer][i] = cnt++;
            }
            for (int i = n - 1 - layer; i > layer; i--) {
                result[i][layer] = cnt++;
            }
            layer++;
        }
        if (n % 2 == 1) {
            result[layer - 1][layer - 1] = cnt;
        }
        return result;
    }
}