/**
 * @author XIAO
 * LeetCode: Number of 1 Bits
 * Description: Write a function that takes an unsigned integer and returns the 
 *              number of ¡¯1' bits it has.
 */

public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = n & 1;
        int i = 1;
        while (i < 32) {
            weight += n>>i & 1;
            i++;
        }
        return weight;   
    }
    /*Sol2 convert int to unsigned int first.*/
    public int hammingWeight(int n) {
        long m = n & 0x00000000ffffffffL;
        int cnt = 0;
    	while (m > 1) {
    		if (m % 2 == 1)
    			cnt++;
    		m /= 2;
    	}
    	if (m == 1) return ++cnt;
    	return cnt;
    }
}