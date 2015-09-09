/**
 * @author Xiao
 * LeetCode: Spiral Matrix
 * Description: Given a matrix of m x n elements (m rows, n columns), return all
 *              elements of the matrix in spiral order.
 *              For example, given the following matrix:
 *              [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 *              You should return [1,2,3,6,9,8,7,4,5].
 * Idea: scan layer by layer from outside to inside.
 */
 
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int layer = 0;
        while (row - 2 >= 0 && col - 2 >= 0) {
            for (int i = layer; i < col - 1 + layer; i++) {
                result.add(matrix[layer][i]);
            }
            for (int i = layer; i < row - 1 + layer; i++) {
                result.add(matrix[i][col - 1 + layer]);
            }
            for (int i = col - 1 + layer; i > layer; i--) {
                result.add(matrix[row - 1 + layer][i]);
            }
            for (int i = row - 1 + layer; i > layer; i--) {
                result.add(matrix[i][layer]);
            }
            row -= 2;
            col -= 2;
            layer++;
        }
        if (row == 1) {
            for (int i = layer; i < col + layer; i++) {
                result.add(matrix[layer][i]);
            }
        } else if (col == 1) {
            for (int i = layer; i < row + layer; i++) {
                result.add(matrix[i][layer]);
            }
        }
        return result;
    }
}