/**
 * @author Xiao
 * LeetCode: Range Sum Query 2D - Immutable
 * Description: Given a 2D matrix matrix, find the sum of the elements inside 
 *              the rectangle defined by its upper left corner (row1, col1) and 
 *              lower right corner (row2, col2).
 */
 
public class NumMatrix {

    private int[][] matrix;
    private int[][] cumMatrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix.clone();
        if (matrix.length > 0) {
            this.cumMatrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                cumMatrix[i][0] = matrix[i][0];
                for (int j = 1; j < matrix[0].length; j++) {
                    cumMatrix[i][j] = cumMatrix[i][j - 1] + matrix[i][j];
                }
            }
        }
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                sum += cumMatrix[i][col2];
            } else {
                sum += cumMatrix[i][col2] - cumMatrix[i][col1 - 1];
            }
        }
        return sum;
    }
}
