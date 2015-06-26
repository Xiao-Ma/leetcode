/**
 * @author Xiao
 * LeetCode: Word Break
 * Description: Given a string s and a dictionary of words dict, determine if 
 *              s can be segmented into a space-separated sequence of one or
 *              more dictionary words.
 * Idea:
 */
 
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict.isEmpty() || s == null || s.length() == 0) {
            return false;
        }
        boolean[] can = new boolean[s.length()];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String word : wordDict) {
            if (word.length() < min) {
                min = word.length();
            }
            if (word.length() > max) {
                max = word.length();
            }
        }
        if (s.length() < min || s.length() == 1 && !wordDict.contains(s)) {
            return false;
        }
        if (wordDict.contains(s)) {
            return true;
        }
        if (wordDict.contains(s.substring(0, 1))) {
            can[0] = true;
        }
        for (int i = min - 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 && inDict(s, wordDict, 0, i)) {
                    can[i] = true;
                    break;
                } else if (i - j > max) {
                    can[i] = false;
                    continue;
                } else if (can[j] && inDict(s, wordDict, j+1, i)) {
                    can[i] = true;
                    break;
                } else {
                    can[i] = false;
                    continue;
                }
            }
        }
        return can[can.length - 1];
    }
    public boolean inDict(String s, Set<String> wordDict, int start, int end) {
        if (end == s.length() - 1) {
            String word = s.substring(start);
            return wordDict.contains(word);
        } else {
            String word = s.substring(start, end+1);
            return wordDict.contains(word);
        }
    }
}