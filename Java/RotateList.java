/**
 * @author Xiao
 * LeetCode: Rotate List
 * Description: Given a list, rotate the list to the right by k places, where k 
 *              is non-negative. For example: Given 1->2->3->4->5->NULL and 
 *              k = 2, return 4->5->1->2->3->NULL.
 * Note: case when k is larger than the length of linked list.
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
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode fast = head;
        int cnt = 0;
        while (cnt < k && fast != null) {
            fast = fast.next;
            cnt++;
        }
        if (fast == null) {
            int new_k = k % cnt;
            if (new_k == 0) {
                return head;
            }
            fast = head;
            cnt = 0;
            while (cnt < new_k) {
                fast = fast.next;
                cnt++;
            }
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = Dummy.next;
        Dummy.next = slow.next;
        slow.next = null;
        return Dummy.next;
    }
}