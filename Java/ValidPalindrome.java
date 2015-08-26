/**
 * @author Xiao
 * LeetCode: Valid Palindrome
 * Description: Given a string, determine if it is a palindrome, considering 
 *              only alphanumeric characters and ignoring cases. For the purpose
 *              of this problem, we define empty string as valid palindrome.
 */
 
public class ValidPalindrome {
    public boolean is Palindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if(!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
            	i++;
            	j--;
            }
        }
        return true;
    }
}