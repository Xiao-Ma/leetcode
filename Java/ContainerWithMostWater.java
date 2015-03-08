/**
 * @author XIAO
 * LeetCode: Container with Most Water
 * Description: 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
			return 0;
		}
		int i = 0;
		int j = height.length - 1;
		int area = Integer.MIN_VALUE;
		while (i < j) {
			area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return area;
    }
}