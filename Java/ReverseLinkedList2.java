/**
 * @author Xiao
 * LeetCode: Reverse Linked List II
 * Description: Reverse a linked list from position m to n. Do it in-place and 
 *              in one-pass. Given m, n satisfy the following condition:
 *              1 ≤ m ≤ n ≤ length of list.
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
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode start = Dummy;
        int i = 0;
        while (i < m - 1) {
            start = start.next;
            i++;
        }
        ListNode q = start.next;
        ListNode p = q;
        while (i < n - 1) {
            if (q.next == null) {
                break;
            }
            start.next = q.next;
            q.next = start.next.next;
            start.next.next = p;
            p = start.next;
            i++;
        }
        return Dummy.next;
    }
}