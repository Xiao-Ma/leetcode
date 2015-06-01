/**
 * @author Xiao
 * LeetCode: Valid Parenthese
 * Description: Given a string containing only parentheses,
 *              determine if the input string is valid.
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
            if ( s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                i++;
                continue;
            } else {
                if (!stack.isEmpty()) {
                	char c = stack.pop();
                	if (c == '(' && s.charAt(i) == ')' ||
                	    c == '[' && s.charAt(i) == ']' ||
                	    c == '{' && s.charAt(i) == '}') {
                		i++;
                		continue;
                	} else {
                		return false;
                	}
                } else {
                    return false;
                }
            } 
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}