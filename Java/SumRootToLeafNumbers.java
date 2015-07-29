/**
 * @author Xiao
 * LeetCode: Sum Root to Leaf Numbers
 * Description: Given a binary tree containing digits from 0-9 only, each 
 *              root-to-leaf path could represent a number. An example is the 
 *              root-to-leaf path 1->2->3 which represents the number 123. Find 
 *              the total sum of all root-to-leaf numbers.
 * Idea: dfs
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
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        int num = root.val;
        int sum = 0;
        TreeNode cur = root;
        s.push(root);
        while (!s.isEmpty) {
            while(cur.left != null) {
                cur = cur.left;
                num = num * 10 + cur.val;
                s.push(cur);
            }
            TreeNode t = s.pop();
            if (t.right != null){
                cur = t.right;
                num = num * 10 + cur.val;
                s.push(cur);
            } else {
                sum += num;
                num /= 10;
            }
        }
        return sum;
    }
    /*recursive solution.*/
    public int sumNumbersDFS(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        int cur = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            return cur;
        } else {
            return dfs(root.left, cur) + dfs(root.right, cur);
        }
    }
}