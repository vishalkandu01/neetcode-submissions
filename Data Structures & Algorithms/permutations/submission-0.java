class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums, res, list, used, 0);
        return res;
    }

    private void solve(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used, int ind) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // int temp = nums[i];
            // nums[i] = nums[ind];
            // nums[ind] = temp;
            used[i] = true;

            list.add(nums[i]);

            solve(nums, res, list, used, ind + 1);

            list.remove(list.size() - 1);
            // temp = nums[i];
            // nums[i] = nums[ind];
            // nums[ind] = temp;
            used[i] = false;
        }
    }
}
