/**
 * @author Xiao
 * LeetCode: Balanced Binary Tree
 * Description: Given a binary tree, determine if it is height-balanced. For 
 *              this problem, a height-balanced binary tree is defined as a 
 *              binary tree in which the depth of the two subtrees of every node
 *              never differ by more than 1.
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
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        //not a good choice, repeating calculation of getHeight for same nodes
        if (Math.abs(left - right) < 2 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        } else {
            return false;
        }
    }
    private int getHeight(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int l = getHeight(t.left);
        int r = getHeight(t.right);
        return Math.max(l, r) + 1;
    }
    /*Solution 2, use -1 to mark that the tree is not balanced.*/
    public boolean isBalancedSol2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (getHeight2(root) == -1) {
            return false;
        }
        return true;
    } 
    private int getHeight2(TreeNode t) {
        if (t == null) {
            return 0;
        }
        int l = getHeight2(t.left);
        int r = getHeight2(t.right);
        if (Math.abs(l - r) > 1 || l == -1 || r == -1) {
            return -1;
        } else {
            return Math.max(l, r) + 1;
        }
    }
}