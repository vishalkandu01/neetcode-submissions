class Solution {
    public int findMin(int[] nums) {
        int mini = 1001;
        
        for (int i = 0; i < nums.length; i++) {
            mini = Math.min(mini, nums[i]);
        }

        return mini;
    }
}
