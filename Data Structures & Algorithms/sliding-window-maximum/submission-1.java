class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // int n = nums.length;
        // int[] res = new int[n - k + 1];
        // int l = 0;

        // for (int r = k - 1; r < n; r++) {
        //     int maxEle = nums[l];
        //     for (int j = l; j <= r; j++) {
        //         maxEle = Math.max(maxEle, nums[j]);
        //     }
        //     res[l] = maxEle;
        //     l++;
        // }

        // return res;





        // int n = nums.length;
        // PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // int[] res = new int[n - k + 1];
        // int index = 0;

        // for (int i = 0; i < n; i++) {
        //     heap.offer(new int[] {nums[i], i});
        //     if (i >= k - 1) {
        //         while (heap.peek()[1] <= i - k) {
        //             heap.poll();
        //         }
        //         res[index++] = heap.peek()[0];
        //     }
        // }

        // return res;





        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while (r < n) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }

            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r + 1) >= k) {
                res[l] = nums[q.getFirst()];
                l++;
            }

            r++;
        }

        return res;
    }
}
