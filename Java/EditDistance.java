/**
 * @author Xiao
 * LeetCode: Edit Distance
 * Description: Given two words word1 and word2, find the minimum number of 
 *              steps required to convert word1 to word2. (each operation is 
 *              counted as 1 step.) You have the following 3 operations 
 *              permitted on a word: (a) Insert a character (b) Delete a 
 *              character (c) Replace a character.
 * Idea: dp. See comment.
 */
 
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word2.length() == 0) {
            return word1.length();
        } else if (word1.length() == 0) {
            return word2.length();
        }
        int[][] min = new int[word1.length()][word2.length()];
        boolean f = false;
        for (int i = 0; i < word1.length(); i++) {
            if (f) {
                min[i][0] = i;
            } else if (word1.charAt(i) == word2.charAt(0)) {
                min[i][0] = i;
                f = true;
            } else {
                min[i][0] = i + 1;
            }
        }
        f = false;
        for (int i = 0; i < word2.length(); i++) {
            if (f) {
                min[0][i] = i;
            } else if (word2.charAt(i) == word1.charAt(0)) {
                min[0][i] = i;
                f = true;
            } else {
                min[0][i] = i + 1;
            }
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    min[i][j] = min[i - 1][j - 1];
                } else {
                    min[i][j] = Math.min(Math.min(min[i - 1][j], min[i][j - 1]),
                                         min[i - 1][j - 1]) + 1;
                }
            }
        }
        return min[word1.length() - 1][word2.length() - 1];
    }
}