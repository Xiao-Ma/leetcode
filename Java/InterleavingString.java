/**
 * @author Xiao
 * LeetCode: Interleaving String
 * Description: Given s1, s2, s3, find whether s3 is formed by the interleaving 
 *              of s1 and s2.
 */
 
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null) {
            if (s2.equals(s3)) {
                return true;
            } else {
                return false;
            }
        }
        if (s2 == null) {
            if (s1.equals(s3)) {
                return true;
            } else {
                return false;
            }
        }
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean state[][] = new boolean[s1.length() + 1][s2.length() + 1];
        state[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s3.charAt(i) && state[i][0]) {
                state[i + 1][0] = true;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s3.charAt(i) && state[0][i]) {
                state[0][i + 1] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && state[i - 1][j]
                || s3.charAt(i + j - 1) == s2.charAt(j - 1) && state[i][j - 1]) {
                    state[i][j] = true;
                }
            }
        }
        return state[s1.length()][s2.length()];
    }
}