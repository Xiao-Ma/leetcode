/**
 * @author Xiao
 * LeetCode: String to Integer
 * Description: Implement atoi to convert a string to an integer.
 */
 
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        long result = 0;
        boolean sign = true;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (str.charAt(i) == '-') {
            sign = false;
            i++;
        } else if (str.charAt(i) == '+') {
            sign = true;
            i++;
        }
        for (; i < str.length(); i++) {
            if (result > Integer.MAX_VALUE) {
        		break;
        	}
            if (Character.isDigit(str.charAt(i))) {
                result = result * 10 + (str.charAt(i) - '0');
            } else {
                break;
            }
        }
        if (sign) {
        	if (result > Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	} else {
        		return (int)result;
        	}
        } else {
            if (-result < Integer.MIN_VALUE) {
            	return Integer.MIN_VALUE;
            } else {
            	return -(int)result;
            }
        }
    }
}