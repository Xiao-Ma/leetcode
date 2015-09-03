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
	    if (root == null) return result;
	    Stack<TreeNode> s = new Stack<TreeNode>();
	    TreeNode cur = root;
	    TreeNode prev = null;
	    while (!s.isEmpty() || cur != null) {
	    	while (cur != null) {
	    		s.push(cur);
	    		cur = cur.left;
	    	}
	    	cur = s.peek();
            //if cur's right child is empty or is traversed
	    	if (cur.right == null || cur.right == prev) { 
	    		prev = s.pop();
	    		result.add(prev.val);
	    		cur = null; //cur already traversed
	    	} else {
	            cur = cur.right;
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