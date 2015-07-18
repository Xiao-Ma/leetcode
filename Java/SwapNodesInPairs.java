/**
 * @author Xiao
 * LeetCode: Swap Nodes in Pairs
 * Description: Given a linked list, swap every two adjacent nodes and return 
 *              its head. For example, Given 1->2->3->4, you should return the 
 *              list as 2->1->4->3. Your algorithm should use only constant 
 *              space. You may not modify the values in the list, only nodes 
 *              itself can be changed.
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
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode n1 = Dummy;
        ListNode n2 = head;
        while (n2 != null && n2.next != null) {
            n1.next = n2.next;
            n2.next = n2.next.next;
            n1.next.next = n2;
            n1 = n2;
            n2 = n2.next;
        }
        return Dummy.next;
    }
}