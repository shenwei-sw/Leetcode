/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }

        Node pre = head;
        Node cur = head.next;
        boolean toInsert = false;

        do{
            if(pre.val <= insertVal && insertVal <= cur.val){
                toInsert = true;
            }
            else if(pre.val > cur.val) {
                if(insertVal >= pre.val || insertVal <= cur.val){
                    toInsert = true;
                }
            }

            if(toInsert){
                pre.next = new Node(insertVal, cur);
                return head;
            }

            pre = cur;
            cur = cur.next;
        }while(pre != head);

        pre.next = new Node(insertVal, cur);
        return head;
    }
}