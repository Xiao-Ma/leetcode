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
        List<int[]> state = new ArrayList<int[]>();
        while (i < n && i >= 0) {
        	int[] cur = new int[2];
            if (j >= n) {
                i--;
                if (i < 0) {
                	break;
                }
                j = state.get(state.size() - 1)[1] +1;
                state.remove((state.size() - 1));
                continue;
            }
            cur[0] = i;
            cur[1] = j;
            if (canPlace(state, cur)) {
                state.add(cur);
                if (state.size() == n) {
                    String[] tmp = draw(state, n);
                    result.add(tmp);
                    state.remove(state.size() - 1);
                    j++;
                } else {
                	j = 0;
                	i++;
                }
                continue;
            } else if (j < n) {
                j++;
                continue;
            }
        }
        return result;
    }
    public boolean canPlace(List<int[]> s, int[] a) {
        if (s.size() == 0) {
            return true;
        }
        for (int i = 0; i < s.size(); i++) {
            if (a[1] == s.get(i)[1] || 
                Math.abs(a[0] - s.get(i)[0]) == Math.abs(a[1] - s.get(i)[1])) {
                    return false;
            }
        }
        return true;
    }
    public String[] draw(List<int[]> s, int n) {
        String[] str_arr = new String[n];
    	for (int i = 0; i < s.size(); i++) {
    		String str = "";
            int q = s.get(i)[1];
            for (int j = 0; j < n; j++) {
                if (j != q) {
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