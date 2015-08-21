/**
 * @author Xiao
 * LeetCode: Basic Calculator
 * Description: Implement a basic calculator to evaluate a simple expression 
 *              string. The expression string may contain open ( and closing 
 *              parentheses ), the plus + or minus sign -, non-negative integers
 *              and empty spaces. You may assume that the given expression is 
 *              always valid.
 * Idea: take care of '-'!!
 */
 
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '+' || c == '-' || c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.pop() != '(') {
                    int right = num.pop();
                    int left = num.pop();
                    num.push(left + right);
                }
                if (!op.isEmpty() && op.peek() == '-') {
                	num.push(-num.pop());
                }
            } else {
                int n = 0;
                while (c <= '9' && c >= '0' ) {
                    n = n * 10 + (c - '0');
                    i++;
                    if (i == s.length()) {
                    	break;
                    }
                    c = s.charAt(i);
                }
                i--;
                if (!op.isEmpty() && op.peek() == '-') {
                	num.push(-n);
                } else {
                	num.push(n);
                }
            }
        }
        while (!op.isEmpty()) {
            int right = num.pop();
            
            int left = num.pop();
            num.push(left + right);
            op.pop();
        }
        return num.pop();
    }
}