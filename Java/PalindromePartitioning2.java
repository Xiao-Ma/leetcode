/**
 * @author Xiao
 * LeetCode: Palindrome Partitioning II
 * Description: Given a string s, partition s such that every substring of the 
 *              partition is a palindrome. Return the minimum cuts needed for a 
 *              palindrome partitioning of s.
 * Idea: dp. Note there's a long palindrome string as test input, save the
 *       palindrome state between each two indices in string s to save time.
 */
 
public class PalindromePartitioning2 {
    public int minCut(Stirng s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] p = isPalindrome(s);
        if (p[0][s.length() - 1]) {
            return 0;
        }
        int[] cut = new int[s.length()];
        for (int i = 0; i < cut.length; i++) {
            cut[i] = i;
        }
        for (int i = 0; i < cut.length; i++) {
            if (p[0][i]) {
                cut[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        if (cut[i] > cut[j-1] + 1) {
                            cut[i] = cut[j-1] + 1;
                        }
                    }
                }
            }
            
        }
        return cut[cut.length - 1];
    }
    private boolean[][] isPalindrome(String s) {
        boolean[][] result = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                result[i - 1][i] = true;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < i - 1; j++) {
                if (result[j + 1][i - 1] && s.charAt(i) == s.charAt(j)) {
                    result[j][i] = true;
                }
            }
        }
        return result;
    }
    /**
     * This second method judge if the substring is palindrome within the loop.
     */
    public int minCutSol2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] p = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        for (int i = 0; i < s.length(); i++) { //col, end point of substring
            cut[i] = i; //max cut
            for (int j = 0; j <= i; j++) { //row, start point of substring
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || p[j + 1][i - 1])) {
                //if s[i~j] is palindrome    
                    p[j][i] = true;
                    if (j == 0) {
                        cut[i] = 0;
                    } else {
                        if (cut[i] > cut[j - 1] + 1) {
                            cut[i] = cut[j - 1] + 1;
                        }
                    }
                }
            }
        }
        return cut[s.length() - 1];
    }
}