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
        if (head == null || head.next == null) {
        	return head;
        }
		ListNode first = head.next;
		head.next = null;
		return helper(head, first);
    }
    public ListNode helper(ListNode head, ListNode first) {
		if (first.next != null) {
			ListNode tmp = first;
			first = first.next;
			tmp.next = head;
			head = tmp;
			return helper(head, first);
		} else {
			first.next = head;
			return first;
		}
	}
}