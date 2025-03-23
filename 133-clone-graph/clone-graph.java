/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = node;
        Node copy = new Node(cur.val);
        map.put(cur, copy);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            copy = map.get(cur);
            copy.neighbors = new ArrayList<Node>();
            for(Node n : cur.neighbors){
                if(!map.containsKey(n)){
                    Node n_copy = new Node(n.val);
                    map.put(n, n_copy);
                    queue.offer(n);
                }
                copy.neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}