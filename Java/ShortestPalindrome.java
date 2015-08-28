/**
 * @author Xiao
 * LeetCode: Shortest Palindrome
 * Description: Given a string S, you are allowed to convert it to a palindrome 
 *              by adding characters in front of it. Find and return the 
 *              shortest palindrome you can find by performing this 
 *              transformation.
 * Idea: KMP to find longest same prefix and suffix
 */
 
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String rev = reverse(s);
        String combine = s + "*" + rev; //avoid s="aaa" -> combine="aaaaaa" which have maxK=6
        int k = -1;
        int i = 0;
        int[] next = new int[combine.length()];
        next[0] = -1;
        while (i < combine.length() - 1) {
            if (k == -1 || combine.charAt(i) == combine.charAt(k)) {
                k++;
                i++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        //k = next[next.length - 1];
        return rev.substring(0, s.length() - k - 1) + s;
    }
    private String reverse(String s) {
        int n = s.length();
        char[] rev = new char[n];
        for(int i = 0; i < n; i++) {
            rev[i] = s.charAt(n-i-1);
        }
        return new String(rev);
    }
}