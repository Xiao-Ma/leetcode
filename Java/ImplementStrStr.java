/**
 * @author Xiao
 * LeetCode: Implement strStr()
 * Description: Implement strStr(). Returns the index of the first occurrence of
 *              needle in haystack, or -1 if needle is not part of haystack.
 * Idea: KMP
 */
 
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1;
        int m = 0;
        while (m < needle.length() - 1) {
            if (k == -1 || needle.charAt(m) == needle.charAt(k)) {
                k++;
                m++;
                next[m] = k;
            } else {
                k = next[k];
            }
        }
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return -1;
    }
}