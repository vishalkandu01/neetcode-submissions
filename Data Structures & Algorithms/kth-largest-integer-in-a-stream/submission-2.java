class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // pq = new PriorityQueue<>();
        pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            add(num);
        }
    }
    
    // public int add(int val) { // when we use minHeap
    //     pq.offer(val);
        
    //     if (pq.size() > k) {
    //         pq.poll();
    //     }

    //     return pq.peek();
    // }


    public int add(int val) { // when we use maxHeap
        pq.offer(val);

        int[] removed = new int[k - 1];
        int count = 0;

        for (int i = 0; i < k - 1 && pq.size() > 1; i++) {
            removed[i] = pq.poll();
            count++;
        }

        int answer = pq.peek();
        
        for (int i = 0; i < count; i++) {
            pq.offer(removed[i]);
        }

        return answer;
    }
}
