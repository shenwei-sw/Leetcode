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
        dfs(pre, head);
        pre.next.prev = null;
        return pre.next;
    }

    public Node dfs(Node pre, Node cur){
        if(cur == null) return pre;
        pre.next = cur;
        cur.prev = pre;

        Node next = cur.next;
        Node tail = dfs(cur, cur.child);
        cur.child = null;
        return dfs(tail, next);
    }
}