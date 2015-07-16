/**
 * @author Xiao
 * LeetCode: Find Minimum in Rotated Sorted Array II
 * Description: Suppose a sorted array is rotated at some pivot unknown to you 
 *              beforehand. Find the minimum element. The array may contain 
 *              duplicates. Follow up for "Find Minimum in Rotated Sorted 
 *              Array": What if duplicates are allowed? Would this affect the 
 *              run-time complexity? How and why?
 * Idea: If duplicates are allowed, in worst cases we cannot exclude half the
 *       possibilities.
 */
 
public class FindMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        if (nums.length == 0 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end && nums[start] >= nums[end]) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                start = mid;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start += 1;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}