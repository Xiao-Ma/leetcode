/**
 * @author Xiao
 * LeetCode: Decode Ways
 * Description: A message containing from A-Z is being encoded to numbers using
 *              the following mapping: A->1, B->2...Z->26. Given an encoded 
 *              message containing digits, determine the total number of ways to
 *              decode it. Given an encoded message "12", it could be decode as 
 *              "AB" (1 2) or "L" (12). The number of ways decoding "12" is 2.
 * Idea: DP, take care of cases include "0".
 */
 
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1 && s.charAt(0) != '0') {
            return 1;
        }
        int[] result = new int[s.length() + 1];
        if (s.charAt(0) < '1' || s.charAt(0) > '9') {
            return 0;
        } else {
            result[0] = 1;
            result[1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return 0;
            } else if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    result[i + 1] = result[i - 1];
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1') {
                result[i + 1] = result[i - 1] + result[i];
            } else if (s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                result[i + 1] = result[i - 1] + result[i];
            } else {
                result[i + 1] = result[i];
            }
        }
        return result[result.length - 1];
    }
}