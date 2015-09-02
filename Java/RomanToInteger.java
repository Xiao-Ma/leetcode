/**
 * @author Xiao
 * LeetCode: Roman to Integer
 * Description: Given a roman numeral, convert it to an integer. Input is 
 *              guaranteed to be within the range from 1 to 3999.
 */
 
public class RomanToInteger {
    public int romanToInt(String s) {
        int prev = romanDigitToInt(s.charAt(0));
        int result = prev;
        for (int i = 1; i < s.length(); i++) {
            int tmp = romanDigitToInt(s.charAt(i));
            if (tmp > prev) {
                result = result + tmp - prev * 2;
            } else {
                result += tmp;
            }
            prev = tmp;
        }
        return result;
    }
    private int romanDigitToInt(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}