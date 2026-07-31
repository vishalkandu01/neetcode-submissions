class Solution {
    private int countDays(int[] weights, int weightCapacity) {
        int day = 1;
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight <= weightCapacity) {
                currentWeight += weight;
            } else {
                day++;
                currentWeight = weight;
            }
        }

        return day;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int requireDays = countDays(weights, mid);

            if (requireDays <= days) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}