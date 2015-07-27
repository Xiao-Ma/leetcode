/**
 * @author Xiao
 * LeetCode: Minimum Depth of Binary Tree
 * Description: Given a binary tree, find its minimum depth. The minimum depth 
 *              is the number of nodes along the shortest path from the root 
 *              node down to the nearest leaf node.
 * Note: when a node has only one child, the height is the height of this child
 *       plus 1, instead of 1!
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
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l == 0 || r == 0) {
            return Math.max(l, r) + 1;
        } else {
            return Math.min(l, r) + 1;
        }
    }
}