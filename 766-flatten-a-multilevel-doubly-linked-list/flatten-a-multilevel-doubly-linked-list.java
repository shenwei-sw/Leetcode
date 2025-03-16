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

        Node pre = new Node(0, null, head, null);
        Node preHead = pre;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            pre.next = cur;
            cur.prev = pre;
            if(cur.next != null) stack.push(cur.next);
            if(cur.child != null) {
                stack.push(cur.child);
                cur.child = null;
            }
            pre = cur;
        }
        preHead.next.prev = null;
        return preHead.next;
    }
}