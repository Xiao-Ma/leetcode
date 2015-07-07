/**
 * @author Xiao
 * LeetCode: Triangle
 * Description: Given a triangle, find the minimum path sum from top to bottom. 
 *              Each step you may move to adjacent numbers on the row below.
 * Idea: DP
 */
 
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] state = new int[n];
        state[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            state[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            int tmp1 = state[0];
            int tmp2 = state[1];
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    state[0] += triangle.get(i).get(j);
                } else if (j == 1) {
                    state[j] = triangle.get(i).get(j) + (tmp1 < tmp2 ? tmp1 : tmp2);
                } else {
                    tmp1 = tmp2;
                    tmp2 = state[j];
                    state[j] = triangle.get(i).get(j) + (tmp1 < tmp2 ? tmp1 : tmp2);
                }
            }
        }
        int sum = state[0];
        for (int i = 1; i < n; i++) {
            if (state[i] < sum) {
                sum = state[i];
            }
        }
        return sum;
    }
}