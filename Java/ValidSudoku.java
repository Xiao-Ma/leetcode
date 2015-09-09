/**
 * @author Xiao
 * LeetCode: Valid Sudoku
 * Description: Determine if a Sudoku is valid. The Sudoku board could be 
 *              partially filled, where empty cells are filled with the 
 *              character '.'.
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable. 
 *       Only the filled cells need to be validated.
 */
 
public class ValidSudoku {
    public boolean isValidSudokuSol2(char[][] board) {
        Set<Character> s = new HashSet<Character>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s.clear();
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        char tmp = board[i * 3 + m][j * 3 + n];
                        if (tmp != '.') {
                            if (!s.contains(tmp)) s.add(tmp);
                            else return false;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            s.clear();
            for (int j = 0; j < 9; j++) {
                char tmp = board[i][j];
                if (tmp != '.') {
                    if (!s.contains(tmp)) s.add(tmp);
                    else return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            s.clear();
            for (int j = 0; j < 9; j++) {
                char tmp = board[j][i];
                if (tmp != '.') {
                    if (!s.contains(tmp)) s.add(tmp);
                    else return false;
                }
            }
        }
        return true;
    }
}