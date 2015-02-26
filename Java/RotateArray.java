/**
 *@Author Xiao Ma
 *LeetCode: Rotate Array
 *Rotate an array of n elements to the right by k steps.
 *For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
*/

public class RotateArray {
    /*Rotate an array nums to the right by k.*/	
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        int newk = k % nums.length;
        if (newk == 0) {
            return;
        }
        reverse(nums, 0, nums.length - newk - 1);
        reverse(nums, nums.length - newk, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    /*Inverse part of an array nums from start to end.*/
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}