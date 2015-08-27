/**
 * @author Xiao
 * LeetCode: Excel Sheet Column Number
 * Description: Given a column title as appear in an Excel sheet, return its 
 *              corresponding column number.
 */
 
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(s.length() - 1 - i);
            int n = Integer.valueOf(c) - 64;
            num += n * Math.pow(26, i);
        }
        return num;
    }
}