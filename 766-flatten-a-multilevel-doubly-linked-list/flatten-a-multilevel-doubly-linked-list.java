/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;

        Node preHead = new Node(0, null, head, null);
        preHead.next = head;
        head.prev = preHead;
        Node pre = preHead;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node cur;
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(cur.next != null) stack.push(cur.next);
            if(cur.child != null) stack.push(cur.child);
            pre.next = cur;
            cur.prev = pre;
            cur.child = null;
            pre = cur;
        }
        preHead.next = head;
        head.prev = null;
        return head;
    }
}