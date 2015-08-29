/**
 * @author Xiao
 * LeetCode: ZigZag Conversion
 * Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a 
 *              given number of rows like this: (you may want to display this 
 *              pattern in a fixed font for better legibility)
 *              P   A   H   N
 *              A P L S I I G
 *              Y   I   R
 *              And then read line by line: "PAHNAPLSIIGYIR". Write the code 
 *              that will take a string and make this conversion given a number 
 *              of rows: string convert(string text, int nRows);
 */
 
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s == null || s.length() == 0) {
			return s;
		}
        String[] result = new String[numRows];
        for (int i = 0; i < numRows; i++) {
        	result[i] = "";
        }
        int[] flag = new int[s.length()];
        int tmp = 0;
        boolean o = true;
        for (int i = 0; i < s.length(); i++) {
            if (tmp == 0) {
                o = true;
            } else if (tmp == numRows - 1) {
                o = false;
            }
            if (o) {
                flag[i] = tmp++;
            } else {
                flag[i] = tmp--;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            result[flag[i]] = result[flag[i]] + s.charAt(i);
        }
        String r = "";
        for (int i = 0; i < numRows; i++) {
            r += result[i];
        }
        return r;
    }
}