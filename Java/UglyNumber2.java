/**
 * @author Xiao
 * LeetCode: Ugly Number II
 * Description: Write a program to find the n-th ugly number. Ugly numbers are 
 *              positive numbers whose prime factors only include 2, 3, 5. For 
 *              example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the 
 *              first 10 ugly numbers. Note that 1 is typically treated as an 
 *              ugly number.
 */
 
public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        int i = 1;
        result[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        while(i < n) {
            int tmp = Math.min(2*result[a], Math.min(3*result[b], 5*result[c]));
            result[i] = tmp;
            i++;
            if (tmp == 2*result[a]) {
                a++;
            }
            if (tmp == 3*result[b]) {
                b++;
            } 
            if (tmp == 5*result[c]){
                c++;
            }
        }
        return result[n - 1];
    }
}