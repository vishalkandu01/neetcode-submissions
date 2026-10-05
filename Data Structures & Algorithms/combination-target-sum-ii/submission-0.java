class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, res, list, 0, 0);
        return res;
    }

    private void solve(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int ind, int sum) {
        if (ind >= candidates.length) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if (sum > target) return;


        list.add(candidates[ind]);
        solve(candidates, target, res, list, ind + 1, sum + candidates[ind]);
        list.remove(list.size() - 1);

        while (ind + 1 < candidates.length && candidates[ind] == candidates[ind + 1]) {
            ind++;
        }

        solve(candidates, target, res, list, ind + 1, sum);
    }
}
