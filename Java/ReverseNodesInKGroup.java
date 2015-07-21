/**
 * @author Xiao
 * LeetCode: Reverse Nodes in k-Group
 * Description: Given a linked list, reverse the nodes of a linked list k at a 
 *              time and return its modified list. If the number of nodes is not
 *              a multiple of k then left-out nodes in the end should remain as 
 *              it is. You may not alter the values in the nodes, only nodes 
 *              itself may be changed. Only constant memory is allowed.
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
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1 || k == 0) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode start = Dummy;
        ListNode end = Dummy;
        int i = 0;
        while (i < k) {
            if (end == null) {
                return Dummy.next;
            }
            end = end.next;
            i++;
        }
        while (end != null) {
            i = 0;
            ListNode p = start.next;
            ListNode q = start.next;
            while (i < k - 1) {
                if (end == null) {
                    end = null;
                } else {
                    end = end.next;
                }
                start.next = q.next;
                q.next = start.next.next;
                start.next.next = p;
                p = start.next;
                i++;
            }
            start = q;
            if (end != null) {
            	end = end.next;
            }
        }
        return Dummy.next;
    }
}