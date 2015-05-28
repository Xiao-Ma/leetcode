/**
 * @author XIAO
 * Leetcode: 3sum
 * Description: Given an array of integers, find all unique triples with zero sum.
 * Idea: sort the array and iterate the smallest numbers.
 * Note: take care of duplicate numbers.
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <3) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == -sum) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    result.add(tmp);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (nums[start] + nums[end] > -sum) {
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else {
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}