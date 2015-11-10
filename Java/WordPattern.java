/**
 * @author Xiao
 * LeetCode: Word Pattern
 * Description: Given a pattern and a string str, find if str follows the same 
 *              pattern. Here follow means a full match, such that there is a 
 *              bijection between a letter in pattern and a non-empty word in 
 *              str.
 * Idea: HashMap.
 */
 
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        } else if (pattern == null || str == null) {
            return false;
        }
        HashMap<Character, String> h = new HashMap<Character, String>();
        HashSet<String> s = new HashSet<String>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (start >= str.length()) { 
                // if the pattern is longer than the number of words
                return false;
            }
            while (str.charAt(start) == ' ') {
                start++;
            }
            end = start;
            while (end < str.length() && str.charAt(end) != ' ') {
                end++;
            }
            String sub = str.substring(start, end);
            if (h.containsKey(c)) {
                if (!h.get(c).equals(sub)) {
                    return false;
                }
            } else {
                if (s.contains(sub)) {
                    return false;
                }
                s.add(sub);
                h.put(c, sub);
            }
            start = end;
        }
        while (end < str.length()) {
            if (str.charAt(end) != ' ') {
                // if the number of words is longer than pattern
                return false;
            }
            end++;
        }
        return true;
    }
}