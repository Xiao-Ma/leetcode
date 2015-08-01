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
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int cnt = 0;
		while (!queue.isEmpty()) {
		    int len = queue.size();
		    int i = 0;
			List<Integer> r = new ArrayList<Integer>();
			while (i < len) {
                i++;
				TreeNode tmp = queue.poll();
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				if (cnt % 2 == 0) {
					r.add(tmp.val);
				} else {
					r.add(0, tmp.val);
				}
			}
			cnt++;
			result.add(r);
		}
		return result;
    }
}