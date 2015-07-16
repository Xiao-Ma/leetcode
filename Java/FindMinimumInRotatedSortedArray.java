/**
 * @author Xiao
 * LeetCode: Find Minimum in Rotated Sorted Array
 * Description: Suppose a sorted array is rotated at some pivot unknown to you
 *              beforehand. Find the minimum element. You may assume no 
 *              duplicate exists in the array.
 * Idea: binary search
 */
 
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}