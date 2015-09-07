/**
 * @author Xiao
 * LeetCode: Count and Say
 * Description: The count-and-say sequence is the sequence of integers beginning
 *              as follows: 1, 11, 21, 1211, 111221, ...
 *              1 is read off as "one 1" or 11.
 *              11 is read off as "two 1s" or 21.
 *              21 is read off as "one 2, then one 1" or 1211.
 *              Given an integer n, generate the nth sequence.
 */
 
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) return s;
        for (int i = 2; i <= n; i++) {
            String tmp = new String(s);
            s = "";
            char cur = tmp.charAt(0);
            int cnt = 1;
            for (int j = 1; j < tmp.length(); j++) {
                if (tmp.charAt(j) == cur) cnt++;
                else {
                    s = s + String.valueOf(cnt) + String.valueOf(cur);
                    cnt = 1;
                    cur = tmp.charAt(j);
                }
            }
            s = s + String.valueOf(cnt) + String.valueOf(cur);
        }
        return s;
    }
}