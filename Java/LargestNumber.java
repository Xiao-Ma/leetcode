/**
 *@Author Xiao Ma
 *LeetCode: Largest Number
 *Given a list of non negative integers, arrange them such that they form the largest number.
 *For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *Return a string.
 */
import java.math.*;

public class LargestNumber {
    public String largestNumber(int[] num) {
        quickSort(num, 0, num.length - 1);
		String s = new String("");
		int sum = 0;
		for (int cnt = 0; cnt < num.length; cnt++) {
			s = s.concat(String.valueOf(num[cnt]));
			sum += num[cnt];
		}
		if (sum == 0) {
			s = "0";
		}
		return s;
    }

    /*Quick sort the array in the order we need.*/
    public void quickSort(int[] num, int low, int high) {
		int i = low;
		int j = high;
		int pivot = num[i + (j - i) / 2];
		while (i < j) {
			while (compare(num[i], pivot)) {
				i++;
			}
			while (compare(pivot, num[j])) {	
				j--;
			}
			if (i <= j) {
				int tmp = num[i];
				num[i] = num[j];
				num[j] = tmp;
				i++;
				j--;
			}
		}
		if (low < j) {
			quickSort(num, low, j);
		}
		if (i < high) {
			quickSort(num, i, high);
		}
	}

	/*A number is "larger" when it forms larger integer at the front.*/
	public boolean compare(int x, int y) {
		int len1 = String.valueOf(x).length();
		int len2 = String.valueOf(y).length();
		double xx = x*Math.pow(10, len2) + y;
		double yy = y*Math.pow(10, len1) + x;		
		return (xx > yy ? true : false);
	}
}