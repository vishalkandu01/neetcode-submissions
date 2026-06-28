class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            minPrice = Math.min(prices[i], minPrice);
        }

        return maxProfit;
    }
}
