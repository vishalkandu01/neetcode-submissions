class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowLength = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        int sum = 0;

        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                minWindowLength = Math.min(minWindowLength, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return minWindowLength == Integer.MAX_VALUE ? 0 : minWindowLength;
    }
}