/**
 * @author Xiao
 * LeetCode: Evaluate Reverse Polish Notation
 * Description: Evaluate the value of an arithmetic expression in Reverse Polish
 *              Notation. Valid operators are +, -, *, /. Each operand may be 
 *              an integer or another expression.
 */
 
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<Integer>();
        for (String s : tokens) {
            if (s.length() > 1) {
                num.push(Integer.valueOf(s));
            } else {
                char c = s.charAt(0);
                if (Character.isDigit(c)) {
                    num.push(c - '0');
                } else {
                    int a = num.pop();
                    int b = num.pop();
                    int result = 0;
                    switch(c) {
                        case '+':
                            result = a + b;
                            break;
                        case '-':
                            result = b - a;
                            break;
                        case '*':
                            result = a * b;
                            break;
                        case '/':
                            result = b / a;
                            break;
                        default:
                            break;
                    }
                    num.push(result);
                }
            }
        }
        return num.pop();
    }
}