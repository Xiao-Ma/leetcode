/**
 * @author Xiao
 * LeetCode: Restore IP Addresses
 * Description: Given a string contains only digits, restore it by returning
 *              all possible valid IP address combinations.
 * Idea: backtracking. Note that single '0' will be valid while "01" will be 
 *       invalid.
 */
 
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() < 4) {
            return result;
        }
        if (s.length() == 4) {
            String sub = s.substring(0, 1).concat(".").concat(s.substring(1, 2)).
                        concat(".").concat(s.substring(2, 3)).concat(".").
                        concat(s.substring(3,4));
            result.add(sub);
            return result;
        }
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = 1;
        }
        dfs(result, s, num, 0, 4);
        return result;
    }
    public void dfs(List<String> r, String s, int[] n, int k, int sum) {
        for (int i = k; i < 4; i++) {
            if (n[i] < 3) {
                n[i] +=1;
                sum += 1;
                if (sum == s.length()) {
                    int[] tmp = new int[4];
                    String sub = "";
                    boolean b = true;
                    for (int j = 0; j < 4; j++) {
                        if (j == 0) {
                            tmp[j] = n[j];
                            int p = Integer.valueOf(s.substring(0, tmp[0]));
                            if (p == 0 && n[0] == 1) {
                                sub = sub.concat("0");
                            } else if (p <= 255 && s.charAt(0) != '0') {
                                sub = sub.concat(String.valueOf(p));
                            } else {
                                b = false;
                            }
                        } else {
                            tmp[j] = tmp[j-1] + n[j];
                            int p = Integer.valueOf(s.substring(tmp[j-1], tmp[j]));
                            if (p == 0 && n[j] == 1) {
                                sub = sub.concat("0");
                            } else if (p <= 255 && s.charAt(tmp[j-1]) != '0') {
                                sub = sub.concat(String.valueOf(p));
                            } else {
                                b = false;
                            }
                        }
                        if (j < 3) {
                            sub = sub.concat(".");
                        }
                    }
                    if (b) {
                        r.add(sub);
                    }
                } else {
                    dfs(r, s, n, i, sum);
                }
                n[i] -= 1;
                sum -= 1;
            }
        }
    }
}