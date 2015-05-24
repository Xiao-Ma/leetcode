/**
 * @author Xiao
 * LeetCode : Longest Substring Without Repeating Characters
 * Description: Given a string, find the length of the longest substring without repeating characters.
 * Idea: slide window.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int len = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<Character>();
        for (int end = 0; end < s.length(); end++) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                len = end - start + 1;
                maxLen = len > maxLen ? len : maxLen;
            } else {
                while (s.charAt(start) != s.charAt(end)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;            
            }
        }
        return maxLen;
    }
}