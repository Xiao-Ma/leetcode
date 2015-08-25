/**
 * @author Xiao
 * LeetCode: Pascal's Triangle
 * Description: Given numRows, generate the first numRows of Pascal's triangle.
 */
 
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> line = new ArrayList<Integer>();
        line.add(1);
        result.add(new ArrayList(line));
        if (numRows == 1) {
            return result;
        }
        line.add(1);
        result.add(new ArrayList(line));
        if (numRows == 2) {
            return result;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> newline = new ArrayList(line);
            for (int j = 1; j < i; j++) {
                int tmp = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                newline.add(j, tmp);
            }
            result.add(newline);
        }
        return result;
    }
}