/**
 * @author Xiao
 * LeetCode: Rotate Image
 * Description: You are given an n x n 2D matrix representing an image. Rotate 
 *              the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 */
 
public class RotateImage {
    /*Simple solution using iteration and extra space.*/
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1) {
            return;
        }
        int len = matrix.length;
        int[][] r = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                r[j][len - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = r[i][j];
            }
        }
    }
    /*Follow up: in-place. Rotate from outside cycle to inside cycle.*/
    public void rotateSol2(int[][] matrix) {
        if (matrix == null || matrix.length == 1) {
            return;
        }
        int num = matrix.length - 1;
        int len = matrix.length;
        int row = 0;
        while (num >= 1) {
            for (int i = row; i < num + row; i++) {
                int tmp = matrix[row][i];
                matrix[row][i] = matrix[len - 1 - i][row];
                matrix[len - 1 - i][row] = matrix[len - 1 - row][len - 1 - i];
                matrix[len - 1 - row][len - 1 - i] = matrix[i][len - 1 - row];
                matrix[i][len - 1 - row] = tmp;
            }
            num -= 2;
            row++;
        }
    }
}