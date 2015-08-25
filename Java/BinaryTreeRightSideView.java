/**
 * @author Xiao
 * LeetCode: Binary Tree Right Side View
 * Description: Given a binary tree, imagine yourself standing on the right side
 *              of it, return the values of the nodes you can see ordered from 
 *              top to bottom.
 * Idea: level-order traversal.
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
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int len = q.size();
        int i = 0;
        while (i < len) {
            TreeNode tmp = q.poll();
            if (tmp.left != null) {
                q.offer(tmp.left);
            }
            if (tmp.right != null) {
                q.offer(tmp.right);
            }
            i++;
            if (i == len) {
                result.add(tmp.val);
                i = 0;
                len = q.size();
            }
        }
        return result;
    }
}