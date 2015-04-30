/**
 * @author XIAO
 * LeetCode: Count Primes
 * Description: Count the number of prime numbers less than a non-negative number n.
 */

public class CountPrimes {
    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) {
			return 0;
		}
		if (n == 3) {
			return 1;
		}
        int cnt = 0;
        byte helper[] = new byte[n];
    
        for (int i = 2; i < n; i++) {
        	if (helper[i] == 0) {
        		cnt ++;
        	}
        	int j = i;
        	while (j < n*1.0/i) {
        		helper[i*j] = 1;
        		j++;
        	}
        }        
        return cnt;
    }
}