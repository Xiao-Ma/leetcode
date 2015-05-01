/**
 * @author XIAO
 * LeetCode: Happy Number
 * Description: Remove all elements from a linked list of integers that have value val.
 * Note: take care of sequence of val, first and last element.
 */

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
        	return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy.next;
        while (q != null) {
        	if (q.val == val) {
        		p.next = q.next;
        		q = q.next;
        	} else {
	        	p = p.next;
	        	if (p == null) {
	        		return dummy.next;
	        	} else {
	        		q = p.next;
	        	}
        	}
        }
        
        return dummy.next;
    }
}