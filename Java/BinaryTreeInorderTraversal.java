/**
 * @author Xiao
 * LeetCode: Binary Tree Inorder Traversal
 * Decription: Given a binary tree, return the inorder traversal of its nodes' 
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
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode cur = root;
        while (!s.isEmpty()) {
            while (cur.left != null) {
                cur = cur.left;
                s.push(cur);
            }
            TreeNode t = s.pop();
            result.add(t.val);
            if (t.right != null) {
                s.push(t.right);
                cur = t.right;
            }
        }
        return result;
    }
    /*recursive solution.*/
    private List<Integer> r = new ArrayList<Integer>();
    public List<Integer> inorderTraversalSol2(TreeNode root) {
        if (root == null) {
            return r;
        }
        inorderTraversalSol2(root.left);
        r.add(root.val);
        inorderTraversalSol2(root.right);
        return r;
    }
}