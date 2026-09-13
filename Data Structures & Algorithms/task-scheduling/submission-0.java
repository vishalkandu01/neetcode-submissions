class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int count : freq) {
            if (count > 0) {
                pq.offer(count);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1;
            int tasksDone = 0;

            List<Integer> remaining = new ArrayList<>();

            while (cycle > 0 && !pq.isEmpty()) {
                int count = pq.poll();
                count--;
                tasksDone++;
                cycle--;
                if (count > 0) {
                    remaining.add(count);
                }
            }

            for (int count : remaining) {
                pq.offer(count);
            }

            if (pq.isEmpty()) {
                time += tasksDone;
            } else {
                time += n + 1;
            }
        }

        return time;
    }
}
