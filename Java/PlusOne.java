/**
 * @author Xiao
 * LeetCode: Plus One
 * Description: Given a non-negative number represented as an array of digits, 
 *              plus one to the number. The digits are stored such that the most
 *              significant digit is at the head of the list.
 */
 
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += carry;
                return digits;
            } else {
                carry = 1;
                digits[i] = 0;
            }
        }
        if (carry == 0) return digits;
        else {
            int[] r = new int[digits.length + 1];
            r[0] = carry;
            return r;
        }
    }
}