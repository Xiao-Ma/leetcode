/**
 * @author Xiao
 * LeetCode: Symmetric Tree
 * Description: Given a binary tree, check whether it is a mirror of itself 
 *              (ie, symmetric around its center). Bonus points if you could 
 *              solve it both recursively and iteratively.
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
public class SymmetricTree {
    /*recursive solution.*/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }
    private boolean symmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val && symmetric(p.left, q.right) && symmetric(p.right, q.left));
    }
    /*iterative solution.*/
    public boolean isSymmetricSol2(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        if (root.left.val != root.right.val) {
            return false;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        TreeNode cur1 = root.left;
        TreeNode cur2 = root.right;
        s1.push(cur1);
        s2.push(cur2);
        while (!s1.isEmpty()) {
            while (cur1.left != null) {
                cur1 =  cur1.left;
                s1.push(cur1);
                cur2 = cur2.right;
                if (cur2 == null || cur1.val != cur2.val) {
                    return false;
                }
                s2.push(cur2);
            }
            if (cur2.right != null) {
                return false;
            }
            TreeNode t1 = s1.pop();
            TreeNode t2 = s2.pop();
            if (t1.right != null) {
                if (t2.left == null || t1.right.val != t2.left.val) {
                    return false;
                }
                cur1 = t1.right;
                cur2 = t2.left;
                s1.push(cur1);
                s2.push(cur2);
            } else {
                if (t2.left != null) {
                    return false;
                }
            }
        }
        return true;
    }
}