/**
 * @author XIAO
 * LeetCode: Single Number
 * Description: Given an array of integers, every element appears twice except for one. Find that single one.
 */

public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A.length == 1) {
			return A[0];
		}
		int i = 1;
		int j = A[0];
		while (i < A.length) {
			j = (j ^ A[i++]); //Seriously... why j = j^A[i++] is faster than j ^= A[i++]?
		}
		return j;
    }
}
