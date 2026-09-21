class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // int[] passengers = new int[1001];

        // for (int[] trip : trips) {
        //     int numPassengers = trip[0];
        //     int from = trip[1];
        //     int to = trip[2];

        //     passengers[from] += numPassengers;
        //     passengers[to] -= numPassengers;
        // }

        // int currentPassengers = 0;

        // for (int i = 0; i <= 1000; i++) {
        //     currentPassengers += passengers[i];

        //     if (currentPassengers > capacity) {
        //         return false;
        //     }
        // }

        // return true;




        Arrays.sort(trips, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int currentPassengers = 0;

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            while (!pq.isEmpty() && pq.peek()[0] <= from) {
                int[] currentTrip = pq.poll();

                currentPassengers -= currentTrip[1];
            }

            currentPassengers += passengers;

            if (currentPassengers > capacity) {
                return false;
            }

            pq.offer(new int[]{to, passengers});
        }
        
        return true;
    }
}