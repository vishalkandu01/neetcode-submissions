class MyHashSet {

    // private boolean set[];

    // public MyHashSet() {
    //     set = new boolean [1000001];
    // }
    
    // public void add(int key) {
    //     set[key] = true;
    // }
    
    // public void remove(int key) {
    //     set[key] = false;
    // }
    
    // public boolean contains(int key) {
    //     return set[key];
    // }





    private LinkedList<Integer>[] buckets;
    private static final int SIZE = 769;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */