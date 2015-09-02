/**
 * @author Xiao
 * LeetCode: Integer to Roman
 * Description: Given an integer, convert it to a roman numeral. Input is 
 *              guaranteed to be within the range from 1 to 3999.
 */
 
public class IntegerToRoman {
    public String intToRoman(int num) {
        String result = "";
        int cnt = 0;
        if (num >= 900) {
            cnt = num / 1000;
            while (cnt-- > 0) {
                result += "M";
            }
            if (num % 1000 >= 900) {
                result += "CM";
                num = num % 1000 - 900;
            } else {
                num = num % 1000;
            }
        }
        if (num >= 500) {
            result += "D";
            num -= 500;
        }
        if (num >= 400) {
        	result += "CD";
        	num -= 400;
        }
        if (num >= 90) {
            cnt = num / 100;
            while (cnt-- > 0) {
                result += "C";
            }
            if (num % 100 >= 90) {
                result += "XC";
                num = num % 100 - 90;
            } else {
                num = num % 100;
            }
        }
        if (num >= 50) {
            result += "L";
            num -= 50;
        }
        if (num >= 40) {
        	result += "XL";
        	num -= 40;
        }
        if (num >= 9) {
            cnt = num / 10;
            while (cnt-- > 0) {
                result += "X";
            }
            if (num % 10 == 9) {
                return result + "IX";
            } else {
                num = num % 10;
            }
        }
        if (num >= 5) {
            result += "V";
            num -= 5;
        } else if (num == 4) {
        	return result + "IV";
        }
        while (num-- > 0) {
            result += "I";
        }
        return result;
    }
}