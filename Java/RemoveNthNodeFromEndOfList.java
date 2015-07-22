/**
 * @author Xiao
 * LeetCode: Remove Nth Node From End of List
 * Description: Given a linked list, remove the nth node from the end of list 
 *              and return its head. Given n will always be valid. Try to do 
 *              this in one pass.
 * Idea: two runners.
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
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null && n == 1) {
            return null;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode p = Dummy;
        ListNode q = Dummy;
        int i = 0;
        while (p != null) {
            if (i > n) {
                q = q.next;
            }
            p = p.next;
            i++;
        }
        q.next = q.next.next;
        return Dummy.next;
    }
}