/**
 * @author Xiao 
 * LeetCode: Count Complete Tree Nodes
 * Description: Given a complete binary tree, count the number of nodes.
 * Idea: direct recursion will exceed time limit, compare the left
 *       most height and right most height, if they are equal, the number of 
 *       nodes can be calculated.
 */
 
/*
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        val = x;
    }
}
*/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = leftHeight(root);
        int r = rightHeight(root);
        if (l == r) {
            return (2 << (l - 1)) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    private int leftHeight(TreeNode n) {
        if (n == null) {
            return 0;
        }
        int cnt = 1;
        while (n.left != null) {
            n = n.left;
            cnt++;
        }
        return cnt;
    }
    private int rightHeight(TreeNode n) {
        if (n == null) {
            return 0;
        }
        int cnt = 1;
        while (n.right != null) {
            n = n.right;
            cnt++;
        }
        return cnt;
    }
    public int countNodesRecursive(TreeNode root) {
        //recursive method in java will exceed time limit
        if (root == null) {
            return 0;
        } else if (root.left == null || root.right == null) {
            return 1;
        } else {
            return countNodesRecursive(root.left) + countNodesRecursive(root.right) + 1;
        }
    }
}