/**
 * @author Xiao
 * LeetCode: Add and Search Word - Data structure design
 * Description: Design a data structure that supports the following two 
 *              operations:
 *                  void addWord(word)
 *                  bool search(word)
 *                  search(word) can search a literal word or a regular 
 *              expression string containing only letters a-z or .. A . means it 
 *              can represent any one letter.
 * Note: You may assume that all words are consist of lowercase letters a-z.
 * Idea: similar to Trie tree.
 */

class TrieNode {
    char val;
    ArrayList<TrieNode> list = new ArrayList<TrieNode>();
    public TrieNode(char c) {
        this.val = c;
    }
}

public class WordDictionary {
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode('#');
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(root, 0, word, 0);
    }
    
    private boolean dfs(TrieNode t, int pos, String word, int start) {
        if (pos >= t.list.size()) {
            return false;
        }
        if (start == word.length()) {
            if (t.list.size() > 0 && t.list.get(0).val == '#') {
                return true;
            } else {
                return false;
            }
        }
        if (word.charAt(start) == '.' && t.list.get(pos).val != '#' || word.charAt(start) == t.list.get(pos).val) {
            if (dfs(t.list.get(pos), 0, word, start + 1)) {
                return true;
            }
        }
        return dfs(t, pos + 1, word, start);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");