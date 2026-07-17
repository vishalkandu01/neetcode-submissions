class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] results = new int[len];

        for (int i = 0; i < len - 1; i++) {
            int day = 0;
            for (int j = i + 1; j < len; j++) {
                day++;
                if (temperatures[i] < temperatures[j]) {
                    results[i] = day;
                    break;
                }
            }
        }

        return results;
    }
}
