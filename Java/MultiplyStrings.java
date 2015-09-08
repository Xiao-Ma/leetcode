/**
 * @author Xiao
 * LeetCode: Multiply Strings
 * Description: Given two numbers represented as strings, return multiplication 
 *              of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * Idea: Use arrays to do big integer multiplication.
 */
 
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] n1 = new int[(len1 - 1) / 4 + 1];
        int[] n2 = new int[(len2 - 1) / 4 + 1];
        for (int i = 0; i < n1.length; i++) {
            if (i == n1.length - 1) {
                n1[i] = Integer.valueOf(num1.substring(0, (len1 - 1) % 4 + 1));
            } else {
                n1[i] = Integer.valueOf(num1.substring(len1 - 4 * (i + 1), len1 - 4 * i));
            }
        }
        for (int i = 0; i < n2.length; i++) {
            if (i == n2.length - 1) {
                n2[i] = Integer.valueOf(num2.substring(0, (len2 - 1) % 4 + 1));
            } else {
                n2[i] = Integer.valueOf(num2.substring(len2 - 4 * (i + 1), len2 - 4 * i));
            }
        }
        int carry = 0;
        ArrayList<Integer> r = new ArrayList<Integer>();
        for (int i = 0; i < n1.length; i++) {
            for (int j = 0; j < n2.length; j++) {
                int tmp = n1[i] * n2[j] + carry;
                if (r.size() > i + j) {
                    tmp = tmp + r.get(i + j);
                }
                if (tmp >= 10000) {
                    carry = tmp / 10000;
                    tmp = tmp % 10000;
                } else {
                    carry = 0;
                }
                if (r.size() > i + j) {
                    r.set(i + j, tmp);
                } else {
                    r.add(tmp);
                }
            }
            while (carry > 0) {
                r.add(carry % 10000);
                carry /= 10000;
            }
        }
        while (carry > 0) {
            r.add(carry % 10000);
            carry /= 10000;
        }
        String s = new String("");
        for (int i = 0; i < r.size(); i++) {
            if (i == r.size() - 1) {
                s = String.valueOf(r.get(i)) + s;
            } else {
                String t = String.valueOf(r.get(i));
                while (t.length() < 4) {
                    t = "0" + t;
                }
                s = t + s;
            }
        }
        return s;
    }
}