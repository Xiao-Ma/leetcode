/**
 * @author Xiao
 * LeetCode: H-Index II
 * Description: Follow up for H-Index: What if the citations array is sorted in 
 *              ascending order? Could you optimize your algorithm?
 * Idea: binary search.
 */
 
public class HIndex2 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        int mid = start + (end - start) / 2;
        while (start + 1 < end) {
            if (citations[mid] > citations.length - 1 - mid) {
                end = mid;
            } else {
                start = mid;
            }
            mid = start + (end - start) / 2;
        }
        if (citations[end] <= citations.length - 1 - end)
        	return citations.length - end - 1;
        else if (citations[start] <= citations.length - 1 - start)
        	return citations.length - start - 1;
        else
        	return citations.length;
    }
}