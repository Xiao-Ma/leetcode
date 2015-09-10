/**
 * @author Xiao
 * LeetCode: Sort Colors
 * Description: Given an array with n objects colored red, white or blue, sort 
 *              them so that objects of the same color are adjacent, with the 
 *              colors in the order red, white and blue. Here, we will use the 
 *              integers 0, 1, and 2 to represent the color red, white, and blue
 *              respectively.
 */
 
public class SortColors {
    public void sortColors(int[] nums) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                x++;
            } else if (nums[i] == 1) {
                y++;
            } else {
                z++;
            }
        }
        int i = 0;
        for (; i < x; i++) {
            nums[i] = 0;
        }
        for (; i < x + y; i++) {
            nums[i] = 1;
        }
        for (; i < x + y + z; i++) {
            nums[i] = 2;
        }
    }
}