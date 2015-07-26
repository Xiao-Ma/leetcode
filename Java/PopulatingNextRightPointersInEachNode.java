/**
 * @author Xiao
 * LeetCode: Populating Next Right Pointers in Each Node I & II
 * Description: Given a binary tree, Populate each next pointer to point to its 
 *              next right node. If there is no next right node, the next 
 *              pointer should be set to NULL.
 * Idea: Level-order traverse.
 *       This solution solves any binary tree, not only full ones.
 */
 
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {
        val = x;
    }
}
*/
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        len = q.size();
        int i = 0;
        while (!q.isEmpty()) {
            TreeLinkNode tmp = q.poll();
            i++; 
            if (tmp.left != null) {
                q.offer(tmp.left);
            }
            if (tmp.right != null) {
                q.offer(tmp.right);
            }
            if (i == len) {
                len = q.size();
                i = 0;
            } else {
                tmp.next = q.peek();
            }
        }
    }
}