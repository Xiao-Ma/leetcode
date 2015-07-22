/**
 * @author Xiao
 * LeetCode: Remove Duplicates from Sorted List II
 * Description: Given a sorted linked list, delete all nodes that have duplicate
 *              numbers, leaving only distinct numbers from the original list.
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
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode p = Dummy;
        while (p != null && p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val && (p.next.next.next == null
                || p.next.next.next.val != p.next.val)) {
                p.next = p.next.next.next;
            } else if (p.next.val == p.next.next.val 
                && p.next.next.next.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return Dummy.next;
    }
}