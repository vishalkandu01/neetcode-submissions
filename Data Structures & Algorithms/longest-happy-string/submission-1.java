class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> y[1] - x[1]
        );

        if (a > 0) pq.offer(new int[]{0, a});
        if (b > 0) pq.offer(new int[]{1, b});
        if (c > 0) pq.offer(new int[]{2, c});

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            if (res.length() >= 2 &&
                res.charAt(res.length() - 1) == getChar(first[0]) &&
                res.charAt(res.length() - 2) == getChar(first[0])) {

                if (pq.isEmpty()) {
                    break;
                }

                int[] second = pq.poll();

                res.append(getChar(second[0]));
                second[1]--;

                if (second[1] > 0) {
                    pq.offer(second);
                }

                pq.offer(first);
            } else {
                res.append(getChar(first[0]));
                first[1]--;

                if (first[1] > 0) {
                    pq.offer(first);
                }
            }
        }

        return res.toString();
    }

    private char getChar(int index) {
        return (char) ('a' + index);
    }
}