/**
 * @author Xiao
 * LeetCode: Different Ways to Add Parentheses
 * Description: Given a string of numbers and operators, return all possible 
 *              results from computing all the different possible ways to group 
 *              numbers and operators. The valid operators are +, - and *.
 * Idea: divide and conquer.
 */
 
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '+' && c != '-' && c != '*') {
                continue;
            }
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
            for (Integer l : left) {
                for (Integer r : right) {
                    if (c == '+') {
                        result.add(l + r);
                    } else if (c == '-') {
                        result.add(l - r);
                    } else {
                        result.add(l * r);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}