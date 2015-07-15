/**
 * @author Xiao
 * LeetCode: Search in Rotated Sorted Array
 * Description: Suppose a sorted array is rotated at some pivot unknown to you 
 *              beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *              You are given a target value to search. If found in the array 
 *              return its index, otherwise return -1. You may assume no 
 *              duplicate exists in the array.
 * Idea: binary search, think about how to eliminate half the probable numbers 
 *       at a time?
 */
 
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (nums[mid] > target && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }
        return -1;
    }
}