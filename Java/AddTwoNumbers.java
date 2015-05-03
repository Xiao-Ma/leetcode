/*
 * @author XIAO
 * LeetCode: Add Two Numbers
 * Description: You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
	    ListNode p = dummy;
	    ListNode p1 = l1;
	    ListNode p2 = l2;
	    int f = 0;
	    while (p1 != null || p2 != null || f != 0) {
	    	int a = 0;
	    	int b = 0;
	    	if (p1 != null) {
	    		a = p1.val;
	    		p1 = p1.next;
	    	}
	    	if (p2 != null) {
	    		b = p2.val;
	    		p2 = p2.next;
	    	}
	    	int sum = a + b + f;
	    	if (sum >= 10) {
	    		f = sum / 10;
	    		sum = sum % 10;
	    	} else {
	    		f = 0;
	    	}
	    	p.next = new ListNode(sum);
	    	p = p.next;
	    }
	    return dummy.next;
    }
}