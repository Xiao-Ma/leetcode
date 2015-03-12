/**
 * @author XIAO
 * LeetCode: Reverse Bits
 * Description: Reverse bits of a given 32 bits unsigned integer.
 */

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
        	result = (result << 1) + (n >> i & 1);
        	i++;
        }
        return result;
    }
}