/**
 * @author Xiao
 * LeetCode: Intersection of Two Linked Lists
 * Description: Write a program to find the node at which the intersection of 
 *              two singly linked lists begins.
 * Note: If the two linked lists have no intersection at all, return null.
 *       The linked lists must retain their original structure after the 
 *       function returns.
 *       You may assume there are no cycles anywhere in the entire linked 
 *       structure.
 *       Your code should preferably run in O(n) time and use only O(1) memory.
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
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        int len1 = 1;
        int len2 = 1;
        while (p.next != null) {
            p = p.next;
            len1++;
        }
        while (q.next != null) {
            q = q.next;
            len2++;
        }
        if (q != p) {
            return null;
        }
        int i = 0;
        p = headA;
        q = headB;
        if (len1 > len2) {
            while (i < len1 - len2) {
                p = p.next;
                i++;
            }
        } else {
            while (i < len2 - len1) {
                q = q.next;
                i++;
            }
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}