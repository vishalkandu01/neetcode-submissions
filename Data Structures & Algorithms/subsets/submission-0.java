class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(nums, res, list, 0);
        return res;
    }

    private void solve(int[] nums, List<List<Integer>> res, List<Integer> list, int ind) {
        if (ind >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        solve(nums, res, list, ind + 1);

        list.add(nums[ind]);
        solve(nums, res, list, ind + 1);
        list.remove(list.size() - 1);
    }
}
