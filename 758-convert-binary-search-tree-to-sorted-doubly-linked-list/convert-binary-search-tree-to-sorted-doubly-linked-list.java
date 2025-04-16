/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Node head = new Node(0);
        Node cur = root;
        Node pre = head;
        Stack<Node> stack = new Stack<>();

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur.left = pre;
            pre.right = cur;      
            pre = cur;
            cur = cur.right;
        }
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }
}