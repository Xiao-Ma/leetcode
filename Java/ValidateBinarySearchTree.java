/**
 * @author Xiao
 * LeetCode: Validate Binary Search Tree
 * Description: Given a binary tree, determine if it is a valid binary search 
 *              tree (BST). Assume a BST is defined as follows:
 *              The left subtree of a node contains only nodes with keys less 
 *              than the node's key.
 *              The right subtree of a node contains only nodes with keys 
 *              greater than the node's key.
 *              Both the left and right subtrees must also be binary search 
 *              trees.
 * Note: when the smallest number in the tree is equal to Integer.MIN_VALUE...
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
public class ValidateBinarySearchTree {
    private int prev = Integer.MIN_VALUE;
    private boolean f = false;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (f && root.val <= prev) {
			return false;
		}
		prev = root.val;
		f = true;
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
    }
    /*Sol2 without global variable, using in-order traversal.*/
    public boolean isValidBSTSol2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        int prev = Integer.MIN_VALUE;
        boolean f = false;
        TreeNode cur = root;
        while (!s.isEmpty()) {
            while (cur.left != null) {
                cur = cur.left;
                s.push(cur);
            }
            TreeNode t = s.pop();
            if (f && t.val <= prev) {
                return false;
            }
            f = true;
            prev = t.val;
            if (t.right != null) {
                cur = t.right;
                s.push(cur);
            }
        }
        return true;
    }
}