/**
 * @author Xiao
 * LeetCode: Binary Tree Level Order Traversal II
 * Description: Given a binary tree, return the bottom-up level order traversal 
 *              of its nodes' values. (ie, from left to right, level by level 
 *              from leaf to root).
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
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int len = q.size();
        int i = 0;
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            while (i < len) {
                TreeNode t = q.poll();
                level.add(t.val);
                i++;
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            result.add(0, level);
            i = 0;
            len = q.size();
        }
        return result;
    }
}