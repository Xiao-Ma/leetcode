/**
 * @author Xiao
 * LeetCode: Generate parentheses
 * Description:
 * Idea: backtracking.
 */

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    public static void helper(List<String> result, String s, int l, int r) {
        if (l == 0 && r == 0) {
            result.add(s);
        }
        if (l > 0) {
            helper(result, s + "(", l - 1, r);
        }
        if (r > 0 && l < r) {
            helper(result, s + ")", l, r - 1);
        }
    }
    /*Non-recursive method.*/
    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }
        char[] state = new char[2*n];
        state[0] = '(';
        int left = 1;
        int right = 0;
        int flag = 0;
        int top = 0;
        while (top >= 0) {
            if (left < n && flag == 0) {
                state[++top] = '(';
                left++;
            } else if (right < left && flag <=1) {
                state[++top] = ')';
                right++;
                flag = 0;
            } else {
                if (left == n && right == n) {
                    String tmp = "";
                    for(int i = 0; i < 2*n; i++) {
                        tmp += state[i];
                    }
                    result.add(tmp);
                }
                if (state[top--] == '(') {
                    flag = 1;
                    left--;
                } else {
                    flag = 2;
                    right--;
                }
            }
        }
        return result;
    }
}