/**
 * @author Xiao
 * LeetCode: Letter Combinations of a phone number
 * Description: Given a digit string, return all possible letter combinations 
 *              that the number could represent.
 */

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0 || (digits.length() == 1 && digits == "1")) {
            return result;
        }
        Node[] num = new Node[8];
        int tmp = 97;
        for (int i = 0; i < 8; i++) {
            num[i] = new Node((char)(tmp++));
            Node cur = num[i];
            cur.next = new Node((char)(tmp++));
            cur = cur.next;
            cur.next = new Node((char)(tmp++));
            if (i == 5 || i == 7) {
                cur = cur.next;
                cur.next = new Node((char)(tmp++));
            }
        }
        helper(num, result, digits, 0, "");
        return result;
    }
    public void helper(Node[] n, List<String> r, String d, int i, String s) {
        int j = (int)(d.charAt(i)) - 50;
        if (j < 0 && i < d.length() - 1) {
        	helper(n, r, d, i+1, s);
        } else if (i >= d.length() - 1) {
        	if (j < 0) {
        		r.add(s);
        	} else {
                Node node = n[j];
                while (node != null) {
                    String str = s + node.c;
                    r.add(str);
                    node = node.next;
                }
        	}
        } else {
            Node node = n[j];
            while (node != null) {
                helper(n, r, d, i+1, s+node.c);
                node = node.next;
            }
        }
    }		
}
class Node {
    char c;
    Node next;
    Node(char ch) {
        this.c = ch;
    }
}