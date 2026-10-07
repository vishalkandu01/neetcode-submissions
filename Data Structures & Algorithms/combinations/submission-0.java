class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(1, n, k, res, list);

        return res;
    }

    private void solve(int start, int n, int k, List<List<Integer>> res, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            solve(i + 1, n, k, res, list);
            list.remove(list.size() - 1);
        }
    }
}