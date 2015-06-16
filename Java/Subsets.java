/**
 * @author Xiao
 * LeetCode: Subsets
 * Description: Given a set of distinct integers, return all possible subsets.
 * Note: Elements in a subset must be in non-descending order.
 *       The solution set must not contain duplicate subsets.
 * Idea: 1. backtracking 2.bit manipulation
 */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length == 0 || nums == null) {
            return result;
        }
        qsort(nums, 0, nums.length - 1);
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);
        subsetHelper(result, list, nums, 0);
        return result;
    }
    public void qsort(int[] S, int start, int end) {
        int pivot = S[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (S[i] < pivot && i < j) {
                i++;
            }
            S[j] = S[i];
            while (S[j] >= pivot && i < j) {
                j--;
            }
            S[i] = S[j];
        }
        S[i] = pivot;
        if (start < i - 1) {
            qsort(S, start, i - 1);
        }
        if (i + 1 < end) {
            qsort(S, i + 1, end);
        }
    }
    public void subsetHelper(List<List<Integer>> result, List<Integer> list, int[] S, int i) {
        for (int j = i; j < S.length; j++) {
            if (!list.contains(S[j])) {
                list.add(S[j]);
                result.add(new ArrayList<Integer>(list));
                subsetHelper(result, list, S, j);
                list.remove(list.size() - 1);
            }
        }
    }
}