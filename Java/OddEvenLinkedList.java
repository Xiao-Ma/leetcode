/**
 * @author Xiao
 * LeetCode: Odd Even Linked List
 * Description: Given a singly linked list, group all odd nodes together 
 *              followed by the even nodes. Please note here we are talking 
 *              about the node number and not the value in the nodes.
 *              You should try to do it in place. The program should run in O(1)
 *              space complexity and O(nodes) time complexity.
 */
 
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyOdd = new ListNode(0);
        dummyOdd.next = head;
        ListNode runner1 = dummyOdd.next;
        ListNode dummyEven = new ListNode(0);
        dummyEven.next = head.next;
        ListNode runner2 = dummyEven.next;
        ListNode runner = head.next.next;
        while (runner != null && runner.next != null) {
            runner1.next = runner;
            runner = runner.next;
            runner1 = runner1.next;
            runner2.next = runner;
            runner = runner.next;
            runner2 = runner2.next;
        }
        if (runner != null) {
            runner1.next = runner;
            runner1 = runner1.next;
            runner2.next = null;
        }
        runner1.next = dummyEven.next;
        return dummyOdd.next;
    }
}