/**
 * @author Xiao
 * LeetCode: Reorder List
 * Description: Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: 
 *              L0→Ln→L1→Ln-1→L2→Ln-2→… You must do this in-place without 
 *              altering the nodes' values.
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
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode p = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        q = p.next;
        p.next = null;
        ListNode tmp = q;
        ListNode head2 = q;
        while (q.next != null) {
            tmp = head2;
            head2 = q.next;
            q.next = head2.next;
            head2.next = tmp;
        }
        p = head.next;
        q = head2.next;
        head.next = head2;
        tmp = head2;
        while (p != null) {
            tmp.next = p;
            p = p.next;
            tmp = tmp.next;
            tmp.next = q;
            if (q != null) {
                q = q.next;
                tmp = tmp.next;
            } 
            
        }
    }
}