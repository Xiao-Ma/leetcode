/**
 * @author Xiao
 * LeetCode: Remove Linked List Elements
 * Description: Remove all elements from a linked list of integers that have 
 *              value val.
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
public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode p = Dummy;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return Dummy.next;
    }
}