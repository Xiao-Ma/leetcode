/**
 * @author Xiao
 * LeetCode: Palindrome Linked List
 * Description: Given a singly linked list, determine if it is a palindrome.
 *              Could you do it in O(n) time and O(1) space?
 * Idea: if a linked list is palindrome, the reverse of it will be the same as
 *       the original linked list. In order to implement it in O(n) time and 
 *       O(1) space, compare the first half and the reverse of the second half.
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
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        ListNode Dummy = new ListNode(0);
        Dummy.next = p.next;
        p.next = null;
        q = Dummy.next;
        p = Dummy.next;
        while (q != null && q.next != null) {
            p = q.next;
            q.next = p.next;
            p.next = Dummy.next;
            Dummy.next = p;
        }
        p = head;
        q = Dummy.next;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}