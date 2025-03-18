class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.pre = head;    
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
            addToHead(node);
            return node.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1){
            Node node = map.get(key);
            node.val = value;
            return;
        }
        if(map.size() == capacity){
            Node nodeToDelete = deleteFromTail();
            map.remove(nodeToDelete.key);
        }
        Node node = new Node(key);
        node.val = value;
        map.put(key, node);
        addToHead(node);
    }

    public void delete(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node){
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.pre = node;
        node.pre = head;
    }

    public Node deleteFromTail(){
        Node node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        return node;
    }

    public class Node {
        int key; 
        int val; 
        Node next;
        Node pre;
        public Node (int _key){
            key = _key;
            val = 0;
            next = null;
            pre = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */