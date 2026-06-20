class Solution {

    private int solve(int[] prices, int i, boolean canBuy) {
        if (i == prices.length) {
            return 0;
        }

        if (canBuy) {
            int buy = -prices[i] + solve(prices, i + 1, false);
            int skip = solve(prices, i + 1, true);

            return Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(prices, i + 1, true);
            int hold = solve(prices, i + 1, false);

            return Math.max(sell, hold);
        }
    }

    public int maxProfit(int[] prices) {
        // return solve(prices, 0, true);


        // greedy solution
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}