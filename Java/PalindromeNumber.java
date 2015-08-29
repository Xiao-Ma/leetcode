/**
 * @author Xiao
 * LeetCode: Palindrome Number
 * Description: Determine whether an integer is a palindrome. Do this without 
 *              extra space.
 */
 
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (0 <= x && x <= 9) {
            return true;
        }
        int y = x;
        int tmp = 0;
        while (y > 9) {
            tmp = tmp * 10 + y % 10;
            y = y / 10;
        }
        tmp = tmp * 10 + y;
        if (tmp == x) {
            return true;
        } else {
            return false;
        }
    }
}