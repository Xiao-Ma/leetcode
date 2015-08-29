/**
 * @author Xiao
 * LeetCode: Construct Binary Tree from Inorder and Postorder Traversal
 * Description: Given inorder and postorder traversal of a tree, construct the 
 *              binary tree. You may assume that duplicates do not exist in the 
 *              tree.
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
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (s1 > e1) {
            return null;
        } else if (s1 == e1) {
            return new TreeNode(inorder[s1]);
        }
        int i = s1;
        for (;i <= e1; i++) {
            if (inorder[i] == postorder[e2]) {
                break;
            }
        }
        TreeNode parent = new TreeNode(postorder[e2]);
        parent.left = build(inorder, s1, i - 1, postorder, s2, s2 + i - s1 - 1);
        parent.right = build(inorder, i + 1, e1, postorder, s2 + i - s1, e2 - 1);
        return parent;
    }
}