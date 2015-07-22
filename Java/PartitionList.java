/**
 * @author Xiao
 * LeetCode: Partition List
 * Description: Given a linked list and a value x, partition it such that all 
 *              nodes less than x come before nodes greater than or equal to x.
 *              You should preserve the original relative order of the nodes in 
 *              each of the two partitions.
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
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode p = left;
        ListNode q = right;
        ListNode runner = head;
        while (runner != null) {
            if (runner.val < x) {
                p.next = runner;
                p = p.next;
            } else {
                q.next = runner;
                q = q.next;
            }
            runner = runner.next;
        }
        q.next = null;
        p.next = right.next;
        return left.next;
    }
}