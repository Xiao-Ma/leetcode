/**
 * @author Xiao
 * LeetCode: Merge Two Sorted Lists
 * Description: Merge two sorted linked lists and return it as a new list. The 
 *              new list should be made by splicing together the nodes of the 
 *              first two lists.
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
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode Dummy = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode runner = Dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                runner.next = p;
                p = p.next;
            } else {
                runner.next = q;
                q = q.next;
            }
            runner = runner.next;
        }
        if (p == null) {
            runner.next = q;
        }
        if (q == null) {
            runner.next = p;
        }
        return Dummy.next;
    }
}