/**
 * @author Xiao
 * LeetCode: Lowest Common Ancestor of a Binary Search Tree
 * Description: Given a binary search tree (BST), find the lowest common 
 *              ancestor (LCA) of two given nodes in the BST. According to the 
 *              definition of LCA on Wikipedia: “The lowest common ancestor is 
 *              defined between two nodes v and w as the lowest node in T that 
 *              has both v and w as descendants (where we allow a node to be a 
 *              descendant of itself).”
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
public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val >= p.val && root.val <= q.val ||
            root.val <=p.val && root.val >=q.val) {
            return root;
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}