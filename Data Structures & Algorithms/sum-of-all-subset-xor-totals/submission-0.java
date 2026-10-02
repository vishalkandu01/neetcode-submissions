class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int xor, int ind) {
        if (ind >= nums.length) {
            return xor;
        }

        int pick = solve(nums, xor ^ nums[ind], ind + 1);

        int notPick = solve(nums, xor, ind + 1);

        return pick + notPick;
    }
}