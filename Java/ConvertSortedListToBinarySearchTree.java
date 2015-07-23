/**
 * @author Xiao
 * LeetCode: Convert Sorted List to Binary Search Tree
 * Description: Given a singly linked list where elements are sorted in 
 *              ascending order, convert it to a height balanced BST.
 */
 
/*
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
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
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode tmp = findMid(head);
        ListNode mid = tmp.next;
        tmp.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    private ListNode findMid(ListNode head) {
        //find the last node before the middle!!
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null && q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
}
