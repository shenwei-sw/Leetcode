/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = null;
        Node cur = head;
        while(cur != null){
            if(!map.containsKey(cur)){
                map.put(cur, new Node(cur.val));
            }
            if(cur.random != null){
                if(!map.containsKey(cur.random)){
                    map.put(cur.random, new Node(cur.random.val));
                }
                map.get(cur).random = map.get(cur.random);
            }
            if(pre != null) map.get(pre).next = map.get(cur);
            pre = cur;
            cur = cur.next;
        }
        return map.get(dummy.next);
    }
}