/**
 * @author Xiao
 * LeetCode: Search in Rotated Sorted Array II
 * Description: Follow up for "Search in Rotated Sorted Array": What if 
 *              duplicates are allowed? Would this affect the run-time 
 *              complexity? How and why? Write a function to determine if a 
 *              given target is in the array.
 * Idea: if using binary search in worst case cannot exclude half of the numbers,
 *       so this would affect the run-time complexity.
 */
 
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (target == nums[0]) {
            return true;
        } else if (target > nums[0]) {
            int i = 1;
            while (i < nums.length) {
                if (nums[i] == target) {
                    return true;
                } else if (i + 1 < nums.length && nums[i + 1] >= nums[i]) {
                    i++;
                } else {
                    break;
                }
            }
        } else {
            int i = nums.length - 1;
            while (i > 0) {
                if (nums[i] == target) {
                    return true;
                } else if (nums[i] >= nums[i - 1]) {
                    i--;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}