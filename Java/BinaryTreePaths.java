/**
 * @author Xiao
 * LeetCode: Binary Tree Paths
 * Description: Given a binary tree, return all root-to-leaf paths. 
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
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (String l : left) {
            String s = Integer.toString(root.val).concat("->").concat(l);
            result.add(s);
        }
        for (String r : right) {
            String s = Integer.toString(root.val).concat("->").concat(r);
            result.add(s);
        }
        return result;
    }
}