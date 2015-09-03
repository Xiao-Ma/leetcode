/**
 * @author Xiao
 * LeetCode: Remove Element
 * Description: Given an array and a value, remove all instances of that value 
 *              in place and return the new length. The order of elements can be
 *              changed. It doesn't matter what you leave beyond the new length.
 * Idea: always swap the position of target value with the last value.
 */
 
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                nums[i] = nums[len - 1];
                len--;
                i--;
            }
        }
        return len;
    }
}