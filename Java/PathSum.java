/**
 * @author XIAO
 * LeetCode: Path Sum
 * Description: Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
			return false;
		}
		int path = root.val;
		if (path == sum && root.left == null && root.right == null) {
			return true;
		} else {
			return (hasPathSum(root.left, sum - path) || hasPathSum(root.right, sum - path));
		}
    }
}