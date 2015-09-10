/**
 * @author Xiao
 * LeetCode: Add Binary
 * Description: Given two binary strings, return their sum (also a binary 
 *              string).
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder s = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                if (carry == 1) {
                    s.insert(0, '1');
                } else {
                    s.insert(0, '0');
                }
                carry = 1;
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                if (carry == 1) {
                    s.insert(0, '1');
                } else {
                    s.insert(0, '0');
                }
                carry = 0;
            } else {
                if (carry == 1) {
                    s.insert(0, '0');
                    carry = 1;
                } else {
                    s.insert(0, '1');
                }
            }
            i--;
            j--;
        }
        if (carry == 0) {
            if (i >= 0) {
                return a.substring(0, i + 1) + s.toString();
            }
            if (j >= 0) {
                return b.substring(0, j + 1) + s.toString();
            }
        } else {
            if (i >= 0) {
                while (carry == 1 && i >= 0) {
                    if (a.charAt(i) == '1') {
                        s.insert(0, '0');
                    } else {
                        s.insert(0, '1');
                        carry = 0;
                    }
                    i--;
                }
                if (carry == 1) {
                    return "1" + s.toString();
                }
                if (i >= 0) {
                    return a.substring(0, i + 1) + s.toString();
                }
            } else if (j >= 0) {
                while (carry == 1 && j >= 0) {
                    if (b.charAt(j) == '1') {
                        s.insert(0, '0');
                    } else {
                        s.insert(0, '1');
                        carry = 0;
                    }
                    j--;
                }
                if (carry == 1) {
                    return "1" + s.toString();
                }
                if (j >= 0) {
                    return b.substring(0, j + 1) + s.toString();
                }
            } else {
                return "1" + s.toString();
            }
        }
        return s.toString();
    }
}