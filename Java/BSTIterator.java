/**
 * @author Xiao
 * LeetCode: Binary Search Tree Iterator
 * Description: Implement an iterator over a binary search tree (BST). Your 
 *              iterator will be initialized with the root node of a BST. 
 *              Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) 
 *       memory, where h is the height of the tree.
 */
 
/*
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
*/
public class BSTIterator {
    
    private Stack<TreeNode> s = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        TreeNode tmp = root;
        while (tmp != null) {
            s.push(tmp);            
            tmp = tmp.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = s.pop();
        int result = tmp.val;
        if (tmp.right != null) {
            tmp = tmp.right;
            while (tmp != null) {
                s.push(tmp);
                tmp = tmp.left;
            }
        }
        return result;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */