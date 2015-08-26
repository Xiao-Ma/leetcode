/**
 * @author Xiao
 * LeetCode: Compare Version Numbers
 * Description: Compare two version numbers version1 and version2. If version1 >
 *              version2 return 1, if version1 < version2 return -1, otherwise 
 *              return 0. You may assume that the version strings are non-empty 
 *              and contain only digits and the . character.
 *              The . character does not represent a decimal point and is used 
 *              to separate number sequences. For instance, 2.5 is not "two and 
 *              a half" or "half way to version three", it is the fifth 
 *              second-level revision of the second first-level revision.
 */
 
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        int n = 0;
        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) != '.') {
                n = n * 10 + Integer.valueOf(version1.charAt(i));
            } else {
                l1.add(n);
                n = 0;
            }
        }
        l1.add(n);
        n = 0;
        for (int i = 0; i < version2.length(); i++) {
            if (version2.charAt(i) != '.') {
                n = n * 10 + Integer.valueOf(version2.charAt(i));
            } else {
                l2.add(n);
                n = 0;
            }
        }
        l2.add(n);
        int i = 0;
        for (; i < l1.size() && i < l2.size(); i++) {
            if (l1.get(i) > l2.get(i)) {
                return 1;
            } else if (l1.get(i) < l2.get(i)) {
                return -1;
            }
        }
        while (i < l1.size()) {
            if (l1.get(i) > 0) {
                return 1;
            }
            i++;
        }
        while (i < l2.size()) {
            if (l2.get(i) < 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}