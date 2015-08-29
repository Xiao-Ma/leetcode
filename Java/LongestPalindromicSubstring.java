/**
 * @author Xiao
 * LeetCode: Longest Palindromic Substring
 * Description: Given a string S, find the longest palindromic substring in S. 
 *              You may assume that the maximum length of S is 1000, and there 
 *              exists one unique longest palindromic substring.
 * Idea: First try: reverse the string and find the LCS.. get time limit exceed.
 *       However, this is a wrong thought!! e.g: "abcdecba" -> "abcedcba" they 
 *       have "abc" or "cba" in common while they are not palindrome.
 *       Second try: DP. If s[i] = s[j] state[i][j] = state[i + 1][j - 1]. 
 */
 
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        boolean[][] state = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    state[i][j] = true;
                } else if (j - i == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        state[i][j] = true;
                        if (j - i > max) {
                        	max = j - i;
                        	start = i;
                        	end = j;
                        }
                    }
                } else if (s.charAt(i) == s.charAt(j) && state[i + 1][j - 1]) {
                    state[i][j] = true;
                    if (j - i > max) {
                        max = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
    
}