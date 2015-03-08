/**
 * @author XIAO
 * LeetCode: Single Number II
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */

public class SingleNumber2 {
    public int singleNumber(int[] A) {
        int i = 0;
		int[] bit = new int[32];
		while (i < A.length) {
			for (int j = 0; j < 32; j++) {
				bit[j] += (A[i] >> j) & 1;
			}
			i++;
		}
		int num = 0;
		for (int j = 0; j < 32; j++) {
			bit[j] %= 3;
			num += bit[j] << j;
		}
		return num;
    }
}