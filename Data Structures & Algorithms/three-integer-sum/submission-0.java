class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1;
            int h = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum == 0) {
                    // List<Integer> list = new ArrayList<>({nums[i], nums[l], nums[h]}); // this doesn't work - remember it
                    // List<Integer> list = new ArrayList<>(); // this will work
                    // list.add(nums[i]);
                    // list.add(nums[l]);
                    // list.add(nums[h]);
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[h]));
                    res.add(list);
                    l++;
                    h--;
                    while (l < h && nums[l] == nums[l - 1]) l++;
                    while (l < h && nums[h] == nums[h + 1]) h--;
                } else if (sum < 0) {
                    l++;
                } else {
                    h--;
                }
            }

        }
        return res;
    }
}
