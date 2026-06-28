class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // int n = nums.length;

        // for (int i = 0; i < n; i++) {
        //     int num = nums[i];
        //     for (int j = i + 1; j < n; j++) {
        //         if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
        //             return true;
        //         }
        //     }
        // }

        // return false;




        // int n = nums.length;
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < n; i++) {
        //     if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
        //         return true;
        //     }
            
        //     map.put(nums[i], i);
        // }

        // return false;




        Set<Integer> set = new HashSet<>();
        int l = 0;
        int n = nums.length;

        for (int h = 0; h < n; h++) {
            if (h - l > k) {
                set.remove(nums[l]);
                l++;
            }
            if (set.contains(nums[h])) return true;
            set.add(nums[h]);
        }

        return false;
    }
}