class LRUCache {
    private int capacity;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addNode(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
            return;
        }

        Node node = new Node(key, value);

        map.put(key, node);
        addNode(node);

        if (map.size() > capacity) {
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    public void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
