/**
 * @author Xiao
 * LeetCode: Move Zeroes
 * Description: Given an array nums, write a function to move all 0's to the end
 *              of it while maintaining the relative order of the non-zero 
 *              elements.
 * Note: You must do this in-place without making a copy of the array.
 *       Minimize the total number of operations.
 */
 
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        Integer zero = null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && zero == null || nums[i] == 0 && zero != null) {
                continue;            	
            } else if (nums[i] == 0 && zero == null) {
                zero = i;
            } else {
                nums[zero] = nums[i];
                nums[i] = 0;
                zero++;
                if (nums[zero] != 0) {
                    zero = null;
                }
            }
        }
    }
}
