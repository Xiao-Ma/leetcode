/**
 * @author Xiao
 * LeetCode: Integer to English Words
 * Description: Convert a non-negative integer to its English words 
 *              representation. Given input is guaranteed to be less than 
 *              2^31-1.
 */
 
public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int remain = num % 1000;
        num /= 1000;
        int thousand = num % 1000;
        num /= 1000;
        int milli = num % 1000;
        num /= 1000;
        String s3 = lessThanThousand(remain);
        String s2 = lessThanThousand(thousand);
        String s1 = lessThanThousand(milli);
        String s0 = lessThanThousand(num);
        String result = "";
        if (num != 0) {
            result = s0 + " Billion";
        }
        if (milli != 0) {
            if (result.length() > 0) 
                result = result + " " + s1 + " Million";
            else
                result = s1 + " Million";
        }
        if (thousand != 0) {
            if (result.length() > 0)
                result = result + " " + s2 + " Thousand";
            else
                result = s2 + " Thousand";
        }
        if (remain != 0) {
            if (result.length() > 0)
            	result = result + " " + s3;
            else
            	result = s3;
        }
        return result;
    }
    private String lessThanThousand(int num) {
        int ones = num % 10;
        num = num / 10;
        int tens = num % 10;
        num = num / 10;
        String s1 = digitToWords(num) + " Hundred";
        String s2 = "";
        String s3 = "";
        String result = "";
        if (num != 0) {
        	result = s1;
        }
        if (tens == 1) {
            switch(ones) {
                case 0:
                    s2 = "Ten";
                    break;
                case 1:
                    s2 = "Eleven";
                    break;
                case 2:
                    s2 = "Twelve";
                    break;
                case 3:
                    s2 = "Thirteen";
                    break;
                case 4:
                    s2 = "Fourteen";
                    break;
                case 5:
                    s2 = "Fifteen";
                    break;
                case 6:
                    s2 = "Sixteen";
                    break;
                case 7:
                    s2 = "Seventeen";
                    break;
                case 8:
                    s2 = "Eighteen";
                    break;
                case 9:
                    s2 = "Nineteen";
                    break;
                default:
                    s2 = "";
                    break;
            }
            if (result.length() > 0)
            	return s1 + " " + s2;
            else
            	return s2;
        } else {
            switch(tens) {
                case 2:
                    s2 = "Twenty";
                    break;
                case 3:
                    s2 = "Thirty";
                    break;
                case 4:
                    s2 = "Forty";
                    break;
                case 5:
                    s2 = "Fifty";
                    break;
                case 6:
                    s2 = "Sixty";
                    break;
                case 7:
                    s2 = "Seventy";
                    break;
                case 8:
                    s2 = "Eighty";
                    break;
                case 9:
                    s2 = "Ninety";
                    break;
                default:
                    s2 = "";
                    break;
            }
        }
        s3 = digitToWords(ones);
        if (tens != 0) {
        	if (result.length() > 0)
        		result = result + " " + s2;
        	else
        		result = s2;
        }
        if (ones != 0) {
        	if (result.length() > 0)
        		result = result + " " + s3;
        	else
        		result = s3;
        }
        return result;
    }
    private String digitToWords(int digit) {
        switch(digit) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }
}