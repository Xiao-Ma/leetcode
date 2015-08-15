/**
 * @author Xiao
 * LeetCode: Search a 2D Matrix II
 * Description: Write an efficient algorithm that searches for a value in an m*n
 *              matrix. This matrix has the following properties:
 *              Integers in each row are sorted in ascending from left to right.
 *              Integers in each column are sorted in ascending from top to 
 *              bottom.
 * Idea: when target > A[i][j], target is larger than column A[0...i][j], when
 *       target < A[i][j], target is smaller than row A[i][j...n-1].
 */
 
public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}