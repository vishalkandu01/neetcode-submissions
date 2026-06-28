class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;
        int[] temp = new int[n];

        for (int i = 0; i < n - k; i++) {
            temp[k + i] = nums[i];
        }

        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }

        return;
    }
}