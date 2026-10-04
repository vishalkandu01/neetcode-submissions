class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, target, res, list, 0, 0);
        return res;
    }

    private void solve(int[] nums, int target, List<List<Integer>> res, List<Integer> list, int ind, int sum) {
        if (ind >= nums.length) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if (sum > target) return;

        if (sum + nums[ind] <= target) {
            list.add(nums[ind]);
            solve(nums, target, res, list, ind, sum + nums[ind]);
            list.remove(list.size() - 1);
        }

        solve(nums, target, res, list, ind + 1, sum);
    }
}
