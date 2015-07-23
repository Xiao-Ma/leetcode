/**
 * @author Xiao
 * LeetCode: Linked List Cycle
 * Description: Given a linked list, determine if it has a cycle in it.
 *              Follow up: Can you solve it without using extra space?
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
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null && q.next != null) {
            if (p == q) {
                return true;
            } else {
                p = p.next;
                q = q.next.next;
            }
        }
        return false;
    }
}