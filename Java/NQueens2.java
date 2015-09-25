/**
 * @author Xiao
 * LeetCode: N-Queens II
 * Description: Follow up for N-Queens problem. Now, instead outputting board 
 *              configurations, return the total number of distinct solutions.
 */
 
public class NQueens2 {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int cnt = 0;
        int i = 0;
        int j = 0;
        int[] state = new int[n];
        for (int c = 0; c < n; c++) {
            state[c] = -1;
        }
        while (i < n && i >= 0) {
            if (j >= n) {
                i--;
                if (i < 0) {
                	break;
                }
                j = state[i] + 1;
                state[i] = -1;
                continue;
            }
            if (canPlace(state, i, j)) {
                state[i] = j;
                if (i == (n - 1)) {
                    cnt++;
                    state[i] = -1;
                    j++;
                } else {
                	j = 0;
                	i++;
                }
            } else {
                j++;
            }
        }
        return cnt;
    }
    
    private boolean canPlace(int[] s, int a, int b) {
        if (s[0] == -1) {
            return true;
        }
        for (int i = 0; i < s.length && s[i] != -1; i++) {
            if (s[i] == b || Math.abs(i - a) == Math.abs(s[i] - b)) {
                    return false;
            }
        }
        return true;
    }
}