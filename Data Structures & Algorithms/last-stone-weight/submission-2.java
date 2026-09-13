class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            int remainingWeight = y - x;
            pq.offer(remainingWeight);

            // pq.offer(pq.poll() - pq.poll());
        }

        return pq.peek();
    }
}
