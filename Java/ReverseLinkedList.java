/**
 * @author Xiao
 * LeetCode: Reverse Linked List
 * Description: Reverse a singly linked list.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //recursive
        if (head == null || head.next == null) {
        	return head;
        }
		ListNode rest = head.next;
		head.next = null;
        ListNode reverse = reverseList(rest);
        rest.next = head;
		return reverse;
    }
    public ListNode reverseListIterative(ListNode head) {
        //iterative
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            p.next = q.next;
            q.next = Dummy.next;
            Dummy.next = q;
            q = p.next;
        }
        return Dummy.next;
    }
}