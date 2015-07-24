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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (root.val > prev) {
			prev = root.val;
		} else {
			return false;
		}
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
    }
}