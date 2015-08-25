/**
 * @author Xiao
 * LeetCode: Implement Trie (Prefix Tree)
 * Description: Implement a trie with insert, search, and startsWith methods.
 *              You may assume that all inputs are consist of lowercase letters 
 *              a-z.
 */
 
class TrieNode {
    char val;
    ArrayList<TrieNode> list = new ArrayList<TrieNode>();
    public TrieNode(char c) {
        this.val = c;
    }
}

public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode('#');
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            boolean exist = false;
            for (int i = 0; i < cur.list.size(); i++) {
                if (cur.list.get(i).val == c) {
                    cur = cur.list.get(i);
                    exist = true;
                    break;
                } 
            }
            if (!exist) {
                cur.list.add(new TrieNode(c));
                cur = cur.list.get(cur.list.size() - 1);
            }
        }
        if (cur.list.isEmpty() || cur.list.get(0).val != '#') {
            cur.list.add(0, new TrieNode('#')); //indicate a word is ended
        }
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            boolean exist = false;
            for (int i = 0; i < cur.list.size(); i++) {
                if (cur.list.get(i).val == c) {
                    cur = cur.list.get(i);
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                return false;
            }
        }
        if (!cur.list.isEmpty() && cur.list.get(0).val == '#') {
            return true; //judge if a word is ended here
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int j = 0; j < prefix.length(); j++) {
            char c = prefix.charAt(j);
            boolean exist = false;
            for (int i = 0; i < cur.list.size(); i++) {
                if (cur.list.get(i).val == c) {
                    cur = cur.list.get(i);
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                return false;
            }
        }
        return true;
    }
}