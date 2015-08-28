/**
 * @author Xiao
 * LeetCode: Longest Palindromic Substring
 * Description: Given a string S, find the longest palindromic substring in S. 
 *              You may assume that the maximum length of S is 1000, and there 
 *              exists one unique longest palindromic substring.
 * Remark: time limit exceeded.. fix later.
 */
 
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        return LCS(s, reverse(s));
    }
    private String reverse(String s) {
        int n = s.length();
        char[] rev = new char[n];
        for(int i = 0; i < n; i++) {
            rev[i] = s.charAt(n-i-1);
        }
        return new String(rev);
    }
    private String LCS(String s1, String s2) {
        int[][] state = new int[s1.length()][s2.length()];
        int end = 0;
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        state[i][j] = 1;
                    } else {
                        state[i][j] = state[i - 1][j - 1] + 1;
                    }
                    if (state[i][j] > max) {
                        max = state[i][j];
                        end = i;
                    }
                }
            }
        }
        return s1.substring(end - max + 1, end + 1);
    }
}