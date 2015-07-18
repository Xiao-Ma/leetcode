/**
 * @author Xiao
 * LeetCode: Sort List
 * Description: Sort a linked list in O(n log n) time using constant space 
 *              complexity.
 * Idea: divide and conquer, merge sort
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
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode fast = Dummy;
        ListNode slow = Dummy;
        while (fast != null && fast.next != null) {
            //find middle
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = Dummy.next;
        ListNode right = slow.next;
        slow.next = null; //break into two half;
        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }
    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        } else if (n2 == null) {
            return n1;
        }
        ListNode d = new ListNode(0);
        ListNode p = d;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if (n1 != null) {
            p.next = n1;
        }
        if (n2 != null) {
            p.next = n2;
        }
        return d.next;
    }
}