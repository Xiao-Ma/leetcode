/**
 * @author Xiao
 * LeetCode: Search Insert Position
 * Description: Given a sorted array and a target value, return the index if the
 *              target is found. If not, return the index where it would be if 
 *              it were inserted in order. You may assume no duplicates in the 
 *              array.
 * Idea: binary search, find the first position >= target.
 */
 
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = end / 2;
        while (start + 1 < end) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
                mid = start + (end - start) / 2;
            } else {
                start = mid;
                mid = start + (end - start) / 2;
            }
        }
        if (target <= nums[start]) {
            return start;
        } else if (target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}