/**
 * @author Xiao
 * LeetCode: Length of Last Word
 * Description: Given a string s consists of upper/lower-case alphabets and 
 *              empty space characters ' ', return the length of last word in 
 *              the string. If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space 
 *       characters only.
 */
 
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (cnt == 0 && s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == ' ') {
                return cnt;
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}