/**
 * @author Xiao
 * LeetCode: Pascal's Triangle II
 * Description: Given an index k, return the kth row of the Pascal's triangle.
 *              Could you optimize your algorithm to use only O(k) extra space?
 */
 
public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
		result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        for (int i = 1; i <= rowIndex; i++) {
            result.add(1);
            int tmp = result.get(0);
            for (int j = 1; j < i; j++) {
                int sum = tmp + result.get(j);
                tmp = result.get(j);
                result.set(j, sum);
            }
        }
        return result;
    }
}