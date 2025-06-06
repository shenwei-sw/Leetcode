/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null) return null;
        Map<Node, NodeCopy> map = new HashMap<>();
        NodeCopy nc = new NodeCopy(root.val);
        map.put(root, nc);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            NodeCopy copy = map.get(cur);
            if(cur.left != null){
                queue.offer(cur.left);
                if(!map.containsKey(cur.left)) map.put(cur.left, new NodeCopy(cur.left.val));
                copy.left = map.get(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
                if(!map.containsKey(cur.right)) map.put(cur.right, new NodeCopy(cur.right.val));
                copy.right = map.get(cur.right);
            }
            if(cur.random != null){
                if(!map.containsKey(cur.random)) map.put(cur.random, new NodeCopy(cur.random.val));
                copy.random = map.get(cur.random);
            }
        }
        return map.get(root);
    }
}