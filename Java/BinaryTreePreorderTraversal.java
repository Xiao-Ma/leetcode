/**
 * @author Xiao
 * LeetCode: Binary Tree Preorder Traversal
 * Decription: Given a binary tree, return the preorder traversal of its nodes' 
 *             values.
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
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode t = s.pop();
            result.add(t.val);
            if (t.right != null) {
                s.push(t.right);
            }
            if (t.left != null) {
                s.push(t.left);
            }
        }
        return result;
    }
    /*recursive solution.*/
    private List<Integer> r = new ArrayList<Integer>();
    public List<Integer> preorderTraversalSol2(TreeNode root) {
        if (root == null) {
            return r;
        }
        r.add(root.val);
        preorderTraversalSol2(root.left);
        preorderTraversalSol2(root.right);
        return r;
    }
}