/**
 * @author Xiao
 * LeetCode: Combination Sum III
 * Description: Find all possible combinations of k numbers that add up to add
 *              number n, given that only numbers from 1 to 9 can be used and
 *              each combination should be a unique set of numbers. Ensure that
 *              numbers within the set are sorted in ascending order.
 * Idea: backtracking, search a tree at depth of k with path sum equals to n.
 */
 
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rslt = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0 || (k/2+n/k)>9) {
            return rslt;
        }
        List<Integer> tmp = new ArrayList<>();
        combHelper(rslt, tmp, 0, k, n);
        return rslt;
    }
    private void combHelper(List<List<Integer>> r, List<Integer> tmp, int cur, int k_rest, int n_rest) {
        if (k_rest == 0 && n_rest == 0) {
            r.add(new ArrayList(tmp));
        } else if (k_rest <= 0) {
            return;
        } else if (n_rest <= 0) {
            return;
        } else {
            for (int i = cur + 1; i < 10; i++) {
                tmp.add(i);
                combHelper(r, tmp, i, k_rest - 1, n_rest - i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}