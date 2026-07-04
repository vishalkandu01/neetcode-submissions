class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int l = 0;

        for (int r = k - 1; r < n; r++) {
            int maxEle = nums[l];
            for (int j = l; j <= r; j++) {
                maxEle = Math.max(maxEle, nums[j]);
            }
            res[l] = maxEle;
            l++;
        }

        return res;
    }
}
