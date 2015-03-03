/**
 *@Author Xiao Ma
 *LeetCode: Find Peak Element
 *A peak element is an element that is greater than its neighbors.
 *Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) {
			return Integer.MIN_VALUE;
		}
		if (num.length == 1) {
			return 0;
		}
		int start = 0;
		int end = num.length - 1;
		int mid = start + (end - start) / 2;
		while (start  + 1 < end) {
			if ((mid == (num.length - 1) || num[mid] > num[mid + 1]) && (mid == 0 || num[mid] > num[mid - 1])) {
				return mid;
			} else if (num[mid] < num[mid + 1]) {
				start = mid;
				mid = start + (end - start) / 2;
			} else {
				end = mid;
				mid = start + (end - start) / 2;
			}
		}
		if (num[start] >= num[end]) {
		    return start;
		} else {
		    return end;
		}
    }
}