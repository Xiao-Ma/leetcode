/**
 * @author Xiao
 * LeetCode: Regular Expression Matching
 * Description: Implement regular expression matching with support for '.' and 
 *              '*'. 
 *              '.' Matches any single character.
 *              '*' Matches zero or more of the preceding element.
 *              The matching should cover the entire input string (not partial).
 */
 
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p == null) {
            if (s == null) return true;
            else return false;
        }
        if (p.length() == 0) {
            if (s.length() == 0) return true;
            else return false;
        }
        return match(s, 0, p, 0);
    }
    private boolean match(String s, int m, String p, int n) {
        if (n == p.length()) {
            if (m == s.length()) return true;
            else return false;
        }
        if (m == s.length()) {
            int len = p.length() - n;
            if (len % 2 == 1) {
                return false;
            } else {
                // for case matching "" and "a*b*c*"
                for (int i = 1; i < len; i += 2) { 
                    if (p.charAt(n + i) != '*') return false;
                }
                return true;
            }
        }
        char star = '0';
        // if p.charAt(n + 1) exist, judge if it is '*'
        if (n < p.length() - 1) star = p.charAt(n + 1); 
        if (star != '*') {
            if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.') {
                return match(s, m + 1, p, n + 1);
            } else {
                return false;
            }
        } else {
            if (s.charAt(m) == p.charAt(n) || p.charAt(n) == '.') {
                return match(s, m + 1, p, n) || match(s, m, p, n + 2);
            } else {
                return match(s, m, p, n + 2);
            }
        }
    }
}