class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < points.length; i++) {
            int distance = euclideanDistance(points[i][0], points[i][1]);
            pq.offer(new int[] {distance, points[i][0], points[i][1]});
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] arr = pq.poll();
            ans[i][0] = arr[1];
            ans[i][1] = arr[2];
        }

        return ans;
    }

    private int euclideanDistance(int x, int y) {
        // double distance = Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
        // return (int)(distance);

        // double distance = Math.sqrt(x*x + y*y);
        // return (int)(distance);

        int distance = x * x + y * y;
        return distance;
    }
}
