/**
 * @author Xiao
 * LeetCode: Excel Sheet Column Title
 * Description: Given a positive integer, return its corresponding column title
 *              as appear in an Excel sheet. For example: 1 -> A, 2 -> B, 3 -> C
 *              ...26 -> Z, 27 -> AA, 28 -> AB 
 */
 
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String result = "";
        while (n > 26) {
            int tmp = n % 26;
            if (tmp == 0) {
                tmp = 26;
            }
            result = Character.toString((char)(tmp + 64)) + result;
            n = (n - 1) / 26;
        }
        result = Character.toString((char)(n + 64)) + result;
        return result;
    }
}