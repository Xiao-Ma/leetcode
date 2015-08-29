/**
 * @author Xiao
 * LeetCode: Construct Binary Tree from Preorder and Inorder Traversal
 * Description: Given preorder and inorder traversal of a tree, construct the 
 *              binary tree. You may assume that duplicates do not exist in the 
 *              tree.
 * Idea:
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
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private static TreeNode build(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s2 > e2) {
            return null;
        } else if (s2 == e2) {
            return new TreeNode(inorder[s2]);
        }
        TreeNode parent = new TreeNode(preorder[s1]);
        int i = s2;
        for (; i <= e2; i++) {
            if (inorder[i] == preorder[s1]) {
                break;
            }
        }
        parent.left = build(preorder, s1 + 1, s1 + i - s2, inorder, s2, i - 1);
        parent.right = build(preorder, s1 + i - s2 + 1, e1, inorder, i + 1, e2);
        return parent; 
    }
}