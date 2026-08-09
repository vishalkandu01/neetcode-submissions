class Solution {
    private boolean splitArraySuccessful(int[] nums, int sumLimit, int k) {
        int partitionCount = 1;
        int subArraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (subArraySum + nums[i] <= sumLimit) {
                subArraySum += nums[i];
            } else {
                partitionCount++;
                subArraySum = nums[i];
            }
            if (partitionCount > k) {
                return false;
            }
        }

        return true;
    }


    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(splitArraySuccessful(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}