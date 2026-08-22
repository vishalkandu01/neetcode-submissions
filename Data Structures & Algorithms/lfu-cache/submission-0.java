class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }

        Node removeLast() {
            if (size == 0) {
                return null;
            }
            
            Node node = tail.prev;
            remove(node);
            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private final int capacity;
    private int minFreq;

    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, DoublyLinkedList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);
        increaseFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            increaseFrequency(node);
            return;
        }

        if (keyToNode.size() == capacity) {
            DoublyLinkedList list = freqToList.get(minFreq);
            Node nodeToRemove = list.removeLast();
            keyToNode.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        freqToList.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(newNode);

        minFreq = 1;
    }

    private void increaseFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqToList.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        node.freq++;

        // freqToList.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addFirst(node);
        DoublyLinkedList list = freqToList.get(node.freq);
        if (list == null) {
            list = new DoublyLinkedList();
            freqToList.put(node.freq, list);
        }
        list.addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */