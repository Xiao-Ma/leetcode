/**
 * @Author Xiao Ma
 * LeetCode: Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * Note that: No two characters may map to the same character but a character may map to itself.
 */

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
        	return true;
        } else if (s == null && t != null || s != null && t == null) {
        	return false;
        }
		if (s.length() != t.length()) {
        	return false;
        }
		HashMap<Character, Character> h = new HashMap<Character, Character>();
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			if (h.containsKey(s.charAt(i))) {
				if (t.charAt(i) == h.get(s.charAt(i))) {
					continue;
				} else {
					return false;
				}
			} else if (h.containsValue(t.charAt(i))) {
				return false;
			} else {
				h.put(s.charAt(i), t.charAt(i));
			}
		}
		return true;
    }
}