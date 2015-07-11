/**
 * @author Xiao
 * LeetCode: Palindrome Partitioning
 * Description: Given a string s, partition s such that every substring of the 
 *              partition is a palindrome. Return all possible palindrome 
 *              partitioning of s.
 * Idea: backtracking
 */
 
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> cur = new ArrayList<String>();
        findAll(result, cur, s, 0, 1);
        return result;
    }
    private void findAll(List<List<String>> r, List<String> c, String s, int start, int end) {
        if (isPalindrome(s, start, end)) {
            c.add(s.substring(start, end));
            if (end == s.length()) {
                r.add(new ArrayList<String>(c));
            } else {
                findAll(r, c, s, end, end + 1);
            }
            c.remove(c.size() - 1);
        }
        if (end < s.length()) {
            findAll(r, c, s, start, end + 1);
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        if (start == end - 1) {
            return true;
        }
        int i = start;
        int j = end - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}