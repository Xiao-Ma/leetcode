/**
 *@Author Xiao Ma
 *LeetCode: Majority Element
 *Given an array of size n, find the majority element. 
 *The majority element is the element that appears more than n/2 times.
 */

import java.util.Stack;

public class MajorityElement {
    public int majorityElement(int[] num) {
        if (num == null || num.length == 0) {
		return Integer.MIN_VALUE;
	}
	Stack<Integer> s = new Stack<Integer>();
	s.push(num[0]);
	for (int i = 1; i < num.length; i++) {
		if (s.isEmpty()) {
			s.push(num[i]);
		} else if (num[i] == s.peek()) {
			s.push(num[i]);
		} else {
			s.pop();
		}
	}
	if (!s.isEmpty()) {
		return s.peek();
	} 
	return Integer.MIN_VALUE;
    }
}