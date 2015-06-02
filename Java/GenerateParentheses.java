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
}