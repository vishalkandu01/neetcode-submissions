class Solution {
    public int maxArea(int[] heights) {
        int s = 0, e = heights.length - 1;
        int maxWaterStore = 0;

        while (s < e) {
            int waterStore = 0;
            if (heights[s] <= heights[e]) {
                waterStore = heights[s++] * (e - s + 1);
            } else {
                waterStore = heights[e--] * (e - s + 1);
            }
            maxWaterStore = Math.max(waterStore, maxWaterStore);
        }

        return maxWaterStore;
    }
}
