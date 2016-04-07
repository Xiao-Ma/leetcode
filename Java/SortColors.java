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
    
    /*Solution 2: keep track of first 1 and first 2. */
    public void sortColors2(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i < p2 + 1) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                p1++;
                i++;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            } else {
                i++;
            }
        }
    }
}