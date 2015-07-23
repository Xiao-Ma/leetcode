/**
 * @author Xiao
 * LeetCode: Copy List with Random Pointer
 * Description: A linked list is given such that each node contains an 
 *              additional random pointer which could point to any node in the 
 *              list or null. Return a deep copy of the list.
 */
 
/*
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode (int x) {
        label = x;
    }
}
*/
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomlistNode head) {
        if (head == null) {
            return null;
        }
        Hashtable<RandomListNode, RandomListNode> h = new Hashtable<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        while (p != null) {
            RandomListNode tmp = new RandomListNode(p.label);
            h.add(p, tmp);
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (p.next == null) {
                h.get(p).next = null;
            } else {
                h.get(p).next = h.get(p.next);
            }
            if (p.random == null) {
                h.get(p).random = null;
            } else {
                h.get(p).random = h.get(p.random); 
            }
            p = p.next;
        }
        return h.get(head);
    }
}