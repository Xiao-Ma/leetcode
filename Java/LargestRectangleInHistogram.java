/**
 * @author Xiao Ma
 * LeetCode: Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
			return 0;
		}
		if (height.length == 1) {
			return height[0];
		}
		int max = 0;
		Node top = new Node(0);
		int i = 1;
		while (i <= height.length) {
			if (top == null || (i < height.length && height[i] >= height[top.data])) {
				Node newNode = new Node(i);
				newNode.next = top;
				top = newNode;
				i++;
			} else {
				int j = top.data;
				top = top.next;
				max = Math.max(max, height[j] * (top == null ? i : i - top.data - 1));
			}
		}
		return max;
    }
}
class Node {
	int data;
	Node next;
	Node(int x) {
		data = x;
	}
}

/**
 * Note: 
 * Idea: keep an increasing stack, so for every pop I can compute the largest area using this bar. 
 * To be faster: 1. Use less caculation (no repeated minus)??
 *               2. Build a data stucture for stack.
 */