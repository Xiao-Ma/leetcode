/**
 * @author Xiao
 * LeetCode: N Queens
 * Description: Given an integer n, return all distinct solutions to the n-queens.
 *              Use '.' indicates empty and 'Q' indicates queen.
 */

public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n <= 0) {
            return result;
        }
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
                    String[] tmp = draw(state, n);
                    result.add(tmp);
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
        return result;
    }
    public boolean canPlace(int[] s, int a, int b) {
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
    public String[] draw(int[] s, int n) {
        String[] str_arr = new String[n];
    	for (int i = 0; i < n; i++) {
            String str = "";
            int tmp = s[i];
            for (int j = 0; j < n; j++) {
                if (j != tmp) {
                    str += '.';
                } else {
                    str += 'Q';
                }
            }
            str_arr[i] = str;
        }
    	return str_arr;
    }
}