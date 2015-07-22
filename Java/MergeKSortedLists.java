/**
 * @author Xiao
 * LeetCode: Merge k Sorted Lists
 * Description: Merge k sorted linked lists and return it as one sorted list. 
 *              Analyze and describe its complexity.
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
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> h = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                h.add(lists[i]);
            }
        }
        ListNode Dummy = new ListNode(0);
        ListNode p = Dummy;
        while (!h.isEmpty()) {
            p.next = h.poll();
            if (p.next.next != null) {
                h.add(p.next.next);
            }
            p = p.next;
        }
        return Dummy.next;
    }
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return 1;
            } else if (l2 == null) {
                return -1;
            }
            return l1.val - l2.val;
        }
    };
}