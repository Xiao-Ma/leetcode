/**
 * @author XIAO
 * LeetCode: Path Sum II
 * Description: Given a binary tree and a sum, 
 * find all root-to-leaf paths where each path's sum equals the given sum.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
		    return result;
		}
		List<Integer> path = new ArrayList<Integer>();
		DFS(root, sum, path, result);
		return result;
    }
    public void DFS(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
		if (root.val == sum && root.left == null && root.right == null) {
			path.add(root.val);
			result.add(new ArrayList<Integer>(path));
			path.remove(path.size() - 1);
			return;
		}
		if (root.left != null) {
			path.add(root.val);
			DFS(root.left, sum - root.val, path, result);
			path.remove(path.size() - 1);
		}
		if (root.right != null) {
			path.add(root.val);
			DFS(root.right, sum - root.val, path, result);
			path.remove(path.size() - 1);
		}
	}
}