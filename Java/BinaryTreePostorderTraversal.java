/**
 * @author Xiao
 * LeetCode: Binary Tree Postorder Traversal
 * Decription: Given a binary tree, return the postorder traversal of its nodes' 
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
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode prev = null;
        TreeNode cur = root;
        while (!s.isEmpty()) {
            while (cur != null && cur.left != null) {
                cur = cur.left;
                s.push(cur);
            }
            cur = s.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
                s.push(cur);
            } else {
                result.add(cur.val);
                prev = s.pop();
                cur = null; //indicate left tree searched
            }
        }
        return result;
    }
    /*recursive solution.*/
    private List<Integer> r = new ArrayList<Integer>();
    public List<Integer> postorderTraversalSol2(TreeNode root) {
        if (root == null) {
            return r;
        }
        postorderTraversalSol2(root.left);
        postorderTraversalSol2(root.right);
        r.add(root.val);
        return r;
    }
}