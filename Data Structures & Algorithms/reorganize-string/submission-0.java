class Solution {
    public String reorganizeString(String s) {
        int freq[] = new int[256];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[] {i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] prev = null;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            result.append((char)current[0]);
            current[1]--;

            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            prev = current;
        }

        if (prev != null && prev[1] > 0) {
            return "";
        }

        return result.toString();
    }
}