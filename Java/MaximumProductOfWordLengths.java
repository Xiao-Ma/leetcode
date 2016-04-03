/**
 * @author Xiao
 * LeetCode: Maximum Product of Word Lengths
 * Description: Given a string array words, find the maximum value of 
 *              length(word[i]) * length(word[j]) where the two words do not 
 *              share common letters. You may assume that each word will contain
 *              only lower case letters. If no such two words exist, return 0.
 */
 
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length <= 1) {
            return 0;
        }
        int[] bitmap = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                bitmap[i] |= 1<<(c-'a');
            }
        }
        int max_prod = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((bitmap[i]&bitmap[j]) == 0) {
                    max_prod = Math.max(max_prod, words[i].length() * words[j].length());
                }
            }
        }
        return max_prod;
    }
}