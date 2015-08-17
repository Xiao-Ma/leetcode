/**
 * @author Xiao
 * LeetCode: Add Digits
 * Description: Given a non-negative integer num, repeatedly add all its digits 
 *              until the result has only one digit.
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * Idea: observe the rule.
 */
 
public class AddDigits {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int a = num % 9;
        if (a == 0) {
            return 9;
        } else {
            return a;
        }
    }
}