/**
 * @author Xiao
 * LeetCode: Flatten Binary Tree to Linked List
 * Description: Given a binary tree, flatten it to a linked list in-place. The
 *              direction follows the right child.
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
public class FlattenBinaryTreeToLinkedList {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        if (prev != null) {
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        flatten(root.left);
        flatten(right);
    }
}