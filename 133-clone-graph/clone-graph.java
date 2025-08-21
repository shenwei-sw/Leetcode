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
        Queue<Node> queue = new LinkedList<>();
        Node copy = new Node(node.val);
        map.put(node, copy);
        queue.offer(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            copy = map.get(cur);
            for(Node nd : cur.neighbors){
                if(!map.containsKey(nd)){
                    Node copy_nd = new Node(nd.val);
                    map.put(nd, copy_nd);
                    queue.offer(nd);
                }
                copy.neighbors.add(map.get(nd));
            }
        }
        return map.get(node);
    }
}