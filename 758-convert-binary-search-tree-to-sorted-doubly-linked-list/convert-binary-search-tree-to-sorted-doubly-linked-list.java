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
        Node cur;
        Node pre = head;
        Node node = root;
        Stack<Node> stack = new Stack<>();

        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            cur = node;
            cur.left = pre;
            pre.right = cur;      
            pre = cur;
            cur = cur.right;
            node = node.right;
        }
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }
}