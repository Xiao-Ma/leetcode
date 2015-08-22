/**
 * @author Xiao
 * LeetCode: Contains Duplicate
 * Description: Given an array of integers, find if the array contains any 
 *              duplicates. Your function should return true if any value 
 *              appears at least twice in the array, and it should return false 
 *              if every element is distinct.
 */
 
import java.util.HashSet;
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (h.contains(nums[i])) {
                return true;
            }
            h.add(nums[i]);
        }
        return false;
    }
}