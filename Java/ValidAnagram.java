/**
 * @author Xiao
 * LeetCode: Valid Anagram
 * Description: Given two strings s and t, write a function to determine if t is
 *              an anagram of s.
 * Idea: Use a hashset.
 */

import java.util.Hashtable; 
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Hashtable<Character, Integer> h = new Hashtable<Character, Integer>();
        int i = 0;
        for(i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
            if (h.containsKey(c)) {
            	h.put(c, h.get(c) + 1);
            } else {
                h.put(c, 1);
            }
        }
        for(i = 0; i < t.length(); i++) {
        	char c = t.charAt(i);
            if (!h.containsKey(c) || h.get(c) == 0) {
                return false;
            } else {
                h.put(c, h.get(c) - 1);
            }
        }
        return true;
    }
}