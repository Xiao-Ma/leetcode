/**
 *@Author Xiao Ma
 *LeetCode: Min Stack
 *Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */

class MinStack {
    Node t;
	Node min;
	
    public void push(int x) {
        Node newNode = new Node(x);
		newNode.next = this.t;
		this.t = newNode;
		if (this.min == null || this.min.data >= x) {
			Node newMin = new Node(x);
			newMin.next = this.min;
			this.min = newMin;
		}
    }

    public void pop() {
        if (this.min.data == this.t.data) {
			this.min = this.min.next;
		}
		this.t = this.t.next;
    }

    public int top() {
    	return this.t.data;
    }

    public int getMin() {
        return this.min.data;
    }
}
class Node {
	int data;
	Node next;
	Node(int x) {
		data = x;
	}
}