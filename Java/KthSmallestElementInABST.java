/**
 * @author Xiao
 * LeetCode: Kth Smallest Element in a BST
 * Description: Given a binary search tree, write a function kthSmallest to find
 *              the kth smallest element in it. You may assume k is always 
 *              valid, 1 ≤ k ≤ BST's total elements. What if the BST is modified
 *              (insert/delete operations) often and you need to find the kth 
 *              smallest frequently? How would you optimize the kthSmallest 
 *              routine?
 * Idea: binary search
 */

/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
*/ 
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int cnt = 1;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (cnt == k) {
                return cur.val;
            } else {
                cnt++;
            }
            cur = cur.right;
        }
        return Integer.MIN_VALUE;
    }
}