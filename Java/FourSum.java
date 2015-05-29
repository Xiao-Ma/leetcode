/**
 * @author Xiao
 * LeetCode: 4Sum
 * Description: Given an integer array, find all identical 4-integer tuples
 *              with sum equals to a given target.
 * Idea: Similar to 3sum, sort first and enumerate 2 number.
 */

public class fourSum {
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
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if  (nums == null || nums.length < 4) {
            return result;
        }  
        qsort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j > i + 2; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int m = i + 1;
                int n = j - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[m]);
                        tmp.add(nums[n]);
                        tmp.add(nums[j]);
                        result.add(tmp);
                        m++;
                        n--;
                        while (m < n && nums[m] == nums[m - 1]) {
                            m++;
                        }
                        while (m < n && nums[n] == nums[n + 1]) {
                            n--;
                        }
                    } else if (sum < target) {
                        m++;
                    } else {
                        n--;
                    }                    
                }
            }
        }
        return result;
    }
}