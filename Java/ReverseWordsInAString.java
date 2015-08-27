/**
 * @author Xiao
 * LeetCode: Reverse Words in a String
 * Description: Given an input string, reverse the string word by word.
 * Clarification: (1)What constitutes a word? A sequence of non-space characters 
 *                constitutes a word.
 *                (2)Could the input string contain leading or trailing spaces? 
 *                Yes. However, your reversed string should not contain leading 
 *                or trailing spaces.
 *                (3)How about multiple spaces between two words? Reduce them to
 *                a single space in the reversed string.
 */
 
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = 0;
        int j = i;
        Stack<String> stack = new Stack<String>();
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                j = i;
            } else if (s.charAt(i) == ' ' && (i > 0) && s.charAt(i - 1) != ' ') {
                stack.push(s.substring(j, i));
            }
        }
        if (s.charAt(s.length() - 1) != ' ') {
            stack.push(s.substring(j));
        }
        if (stack.isEmpty()) {
            return "";
        }
        String result = stack.pop();
        while (!stack.isEmpty()) {
            result = result + " " + stack.pop();
        }
        return result;
    }
}