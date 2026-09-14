class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] sortedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }

        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[2], b[2]);
            }
        );

        int[] result = new int[n];

        int taskIndex = 0;
        int resultIndex = 0;

        long currentTime = 0;

        while (resultIndex < n) {
            while (taskIndex < n && sortedTasks[taskIndex][0] <= currentTime) {
                pq.offer(sortedTasks[taskIndex]);
                taskIndex++;
            } 

            if (pq.isEmpty()) {
                currentTime = sortedTasks[taskIndex][0];
                continue;
            }

            int[] task = pq.poll();
            result[resultIndex++] = task[2];
            currentTime += task[1];
        }

        return result;
    }
}