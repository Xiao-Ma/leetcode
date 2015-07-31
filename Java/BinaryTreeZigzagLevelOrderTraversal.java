/**
 * @author Xiao
 * LeetCode: Binary Tree Zigzag Level Order Traversal
 * Description: Given a binary tree, return the zigzag level order traversal of 
 *              its nodes' values. (ie, from left to right, then right to left 
 *              for the next level and alternate between).
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
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        boolean direction = true;
        while (!s.isEmpty()) {
            int len = s.size();
            int i = 0;
            List<Integer> r = new ArrayList<Integer>();
            while (i < len) {
                i++;
                TreeNode tmp = s.pop();
                if (tmp.left != null) {
                    s.push(tmp.left);
                }
                if (tmp.right != null) {
                    s.push(tmp.right);
                }
                if (direction) {
                    r.add(0, tmp.val);
                } else {
                    
                    r.add(r.size(), tmp.val);
                }
            }
            if (direction) {
                direction = false;
            } else {
                direction = true;
            }
            result.add(r);
        }
        return result;
    }
}