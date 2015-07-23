/**
 * @author Xiao
 * LeetCode: Insertion Sort List
 * Description: Sort a linked list using insertion sort.
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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = head;
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode tmp = p;
            p = p.next;
            ListNode i = Dummy;
            while (i.next != null && i.next.val < tmp.val) {
                i = i.next;
            }
            tmp.next = i.next;
            i.next = tmp;
        }
        return Dummy.next;
    }
}