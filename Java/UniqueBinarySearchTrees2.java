/**
 * @author Xiao 
 * LeetCode: Unique Binary Search Trees II
 * Description: Given n, generate all structurally unique BST's (binary search 
 *              trees) that store values 1...n.
 * Idea: divide and conquer
 */
 
public class UniqueBinarySearchTrees2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null); //empty child
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (int m = 0; m < left.size(); m++) {
                for (int n = 0; n < right.size(); n++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(m);
                    root.right = right.get(n);
                    result.add(root);
                }
            }
        }
        return result;
    }
}