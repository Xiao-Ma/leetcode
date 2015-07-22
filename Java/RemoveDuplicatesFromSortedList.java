/**
 * @author Xiao
 * LeetCode: Remove Duplicates from Sorted List
 * Description: Given a sorted linked list, delete all duplicates such that each
 *              element appear only once.
 * Idea: take care of a sequence of identical numbers.
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
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null) {
            if (p.next != null && p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}