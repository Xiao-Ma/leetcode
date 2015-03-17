/**
 * @author XIAO
 * LeetCode: Two Sum
 * Description: Given an array of integers and a target,
 * find two numbers such that they add up to a specific target number.
 * Return the two indices.
 */

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length ==0 || numbers.length == 1) {
			return null;
		}
		int[] result = new int[2];
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			h.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			if (h.containsKey(target - numbers[i]) && h.get(target - numbers[i]) != i) {
				result[0] = i + 1;
				result[1] = h.get(target - numbers[i]) + 1;
				return result;
			}
		}
		return null;
    }
}