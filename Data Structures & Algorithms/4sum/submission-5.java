class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for (int i = 0; i < n - 3; i++) {
        //     for (int j = i + 1; j < n - 2; j++) {
        //         for (int k = j + 1; k < n - 1; k++) {
        //             for (int l = k + 1; l < n; l++) {
        //                 long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
        //                 if (sum == target) {
        //                     List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
        //                     Collections.sort(list);
        //                     set.add(list);
        //                 }
        //             }
        //         }
        //     }
        // }

        // // List<List<Integer>> res = new ArrayList<>();
        // // for (List<Integer> entry : set) {
        // //     res.add(entry);
        // // }

        // // List<List<Integer>> res = new ArrayList<>(set);
        // // return res;

        // return new ArrayList<>(set);



        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int s = j + 1;
                int e = n - 1;
                while (s < e) {
                    long sum = (long) nums[i] + nums[j] + nums[s] + nums[e];
                    if (sum == target) {
                        set.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[s++], nums[e--])));
                    } else if (sum < target) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }
}