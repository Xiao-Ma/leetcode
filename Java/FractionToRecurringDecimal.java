/**
 * @author Xiao 
 * LeetCode: Fraction to Recurring Decimal
 * Description: Given two integers representing the numerator and denominator 
 *              of a fraction, return the fraction in string format. If the 
 *              fractional part is repeating, enclose the repeating part in 
 *              parentheses.
 * Note: the recurring part could be part of the decimal; take care of negative
 *       numbers and overflow.
 */
 
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        int sign = 1;
		if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
			sign = -1;
		}
		long num = numerator;
		long den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
		String quotient = Long.toString(num / den);
		if (sign == -1) {
			quotient = "-" + quotient;
		}
        if (num % den == 0) {
            return quotient;
        }
        long remainder = num % den;
        String fraction = "";
        Hashtable<Long, Integer> h = new Hashtable<Long, Integer>();
        int cnt = 0;
        while (remainder != 0 && (!h.containsKey(remainder) || h.get(remainder) < 2)) {
            if (h.containsKey(remainder)) {
                h.put(remainder, 2);
                cnt++;
            } else {
                fraction += Long.toString(Math.abs(remainder * 10 / denominator));
                h.put(remainder, 1);
            }
            remainder = remainder * 10 % denominator;
        }
        if (remainder == 0) {
            return quotient + "." + fraction;
        } else {
            return (quotient + "." + fraction.substring(0, fraction.length() - cnt)
                + "(" + fraction.substring(fraction.length() - cnt) + ")");
        }
    }
}