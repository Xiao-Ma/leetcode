/**
 * @author Xiao
 * LeetCode: Same Tree
 * Description: Given two binary trees, write a function to check if they are 
 *              equal or not. Two binary trees are considered equal if they are 
 *              structurally identical and the nodes have the same value.
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
public class SameTree {
    /*recursive solution*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val &&
            isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
            return true;
        }
        return false;
    }
    /*iterative solution*/
    pulic boolean isSameTreeSol2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.add(p);
        s2.add(q);
        TreeNode cur1 = p;
        TreeNode cur2 = q;
        while (!s1.isEmpty()) {
            while (cur1.left != null) {
                cur1 =  cur1.left;
                s1.push(cur1);
                cur2 = cur2.left;
                if (cur2 == null || cur1.val != cur2.val) {
                    return false;
                }
                s2.push(cur2);
            }
            if (cur2.left != null) {
                return false;
            }
            TreeNode t1 = s1.pop();
            TreeNode t2 = s2.pop();
            if (t1.right != null) {
                if (t2.right == null || t1.right.val != t2.right.val) {
                    return false;
                }
                cur1 = t1.right;
                cur2 = t2.right;
                s1.push(cur1);
                s2.push(cur2);
            } else {
                if (t2.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
}