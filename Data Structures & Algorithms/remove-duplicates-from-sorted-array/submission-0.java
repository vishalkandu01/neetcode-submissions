class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ind = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                nums[ind] = nums[i];
                ind++;
            }
        }

        return ind;
    }
}