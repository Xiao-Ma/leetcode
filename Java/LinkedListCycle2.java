/**
 * @author Xiao
 * LeetCode: Linked List Cycle II
 * Description: Given a linked list, return the node where the cycle begins. 
 *              If there is no cycle, return null. Follow up: Can you solve it 
 *              without using extra space?
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
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                p = head;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}