/**
 * @author Xiao
 * LeetCode: Shortest Palindrome
 * Description: Given a string S, you are allowed to convert it to a palindrome 
 *              by adding characters in front of it. Find and return the 
 *              shortest palindrome you can find by performing this 
 *              transformation.
 * Remark: not AC for time limit exceeded. Fix later.
 */
 
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        }
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (isPalindrome(s.substring(0, i))) {
                break;
            }
        }
        return reverse(s.substring(i)) + s;
        
    }
    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    private String reverse(String s) {
        int n = s.length();
        char[] rev = new char[n];
        for(int i = 0; i < n; i++) {
            rev[i] = s.charAt(n-i-1);
        }
        return new String(rev);
    }
}