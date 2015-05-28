/**
 * @author Xiao
 * LeetCode: 3Sum Closest
 * Description: Given an array of integers,
                return a three-integer-sum closest to the given target.
 * Idea: sort first, always record the smallest diff and sum, similar to 3sum.
 */

public class ThreeSumClosest {
    public void qsort(int[] A, int start, int end) {
        int pivot = A[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && A[j] > pivot) {
                j--;
            }
            A[i] = A[j];
            while (i < j && A[i] <= pivot) {
                i++;
            }
            A[j] = A[i];
        }
        A[i] = pivot;
        if (i - 1 > start) {
            qsort(A, start, i - 1);
        }
        if (i + 1 < end) {
            qsort(A, i + 1, end);
        }
    }
    public int threeSumClosest(int[] nums, int target) {
        qsort(nums, 0, nums.length - 1);
        int mindiff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                //System.out.println(sum);
                if (sum == target) {
                    return target;
                }
                int diff = target - sum;
                if (Math.abs(diff) < mindiff) {
                    mindiff = Math.abs(diff);
                    result = sum;
                }
                if (diff >0) {
                    start++;
                }
                if (diff  < 0) {
                    end--;
                }
            }
        }
        return result;
    }
}