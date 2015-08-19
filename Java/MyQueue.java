/**
 * @author Xiao
 * LeetCode: Implement Queue using Stacks
 * Description: Implement the following operations of a queue using stacks.
 *              push(x) -- Push element x to the back of queue.
 *              pop() -- Removes the element from in front of queue.
 *              peek() -- Get the front element.
 *              empty() -- Return whether the queue is empty.
 * Notes: You must use only standard operations of a stack -- which means only 
 *        push to top, peek/pop from top, size, and is empty operations are 
 *        valid.
 *        Depending on your language, stack may not be supported natively. You 
 *        may simulate a stack by using a list or deque (double-ended queue), as
 *        long as you use only standard operations of a stack.
 *        You may assume that all operations are valid (for example, no pop or 
 *        peek operations will be called on an empty queue).
 */
 
class MyQueue {
    private Stack<Integer> s = new Stack<Integer>();
    private Stack<Integer> tmp = new Stack<Integer>();
    
    public void push(int x) {
        if (s.isEmpty()) {
            s.push(x);
        } else {
            while (!s.isEmpty()) {
                tmp.push(s.pop());
            }
            tmp.push(x);
            while (!tmp.isEmpty()) {
                s.push(tmp.pop());
            }
        }
    }
    public void pop() {
        s.pop();
    }
    public int peek() {
        return s.peek();
    }
    public boolean empty() {
        return s.isEmpty();
    }
}