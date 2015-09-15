/**
 * @author Xiao
 * LeetCode: Majority Element
 * Description: Given an array of size n, find the majority element. The 
 *              majority element is the element that appears more than n/2 times.
 */

import java.util.Stack;

public class MajorityElement {
    public int majorityElement(int[] num) {
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
    /*Sol2 without stack, use an Integer to record candidate number.*/
    public int majorityElementSol2(int[] num) {
        int candidate = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < num.length; i++) {
            if (cnt == 0) {
                candidate = num[i];
                cnt = 1;
            } else if (num[i] != candidate) {
                cnt--;
            } else {
                cnt++;
            }
        }
        return candidate;
    }
}