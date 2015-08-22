/**
 * @author Xiao
 * LeetCode: Basic Calculator II
 * Description: Implement a basic calculator to evaluate a simple expression 
 *              string. The expression string contains only non-negative 
 *              integers, +, -, *, / operators and empty spaces . The integer 
 *              division should truncate toward zero. You may assume that the 
 *              given expression is always valid.
 */
 
public class BasicCalculator2 {
    public int calculate(String s) {
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                op.push(c);
            } else {
                int n = 0;
                while (c >= '0' && c <= '9') {
                    n = n * 10 + (c - '0');
                    i++;
                    if (i == s.length()) {
                        break;
                    }
                    c = s.charAt(i);
                }
                i--;
                if (!op.isEmpty() && op.peek() == '*') {
                    num.push(num.pop() * n);
                    op.pop();
                } else if (!op.isEmpty() && op.peek() == '/') {
                    num.push(num.pop() / n);
                    op.pop();
                } else if (!op.isEmpty() && op.peek() == '-') {
                    num.push(-n);
                } else {
                	num.push(n);
                }
            }
        }
        int result = num.pop();
        while (!num.isEmpty()) {
            result += num.pop();
        }
        return result;
    }
}