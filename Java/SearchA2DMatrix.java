/**
 * @author Xiao
 * LeetCode: Search a 2D Matrix
 * Description: Write an efficient algorithm that searches for a value in an m*n 
 *              matrix. This matrix has the following properties: Integers in 
 *              each row are sorted from left to right. The first integer of 
 *              each row is greater than the last integer of the previous row.
 * Idea: binary search row first, then column.
 */
 
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        int row = 0;
        int len = matrix[0].length;
        boolean f = false;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid;
            } else if (matrix[mid][len - 1] < target) {
                start = mid;
            } else {
                row = mid;
                f = true;
                break;
            }
        }
        if (matrix[start][0] <= target && target <= matrix[start][len - 1] && !f) {
			row = start;
		} else if (matrix[end][0] <= target && target <= matrix[end][len - 1] && !f) {
			row = end;
		}
        start = 0;
        end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}