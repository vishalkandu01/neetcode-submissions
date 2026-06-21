class Solution {
    public int firstMissingPositive(int[] nums) {
        // Arrays.sort(nums);
        // int missingPositiveInteger = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     if (i > 0 && nums[i] == nums[i - 1]) continue;
        //     if (nums[i] > 0 && nums[i] == missingPositiveInteger) {
        //         missingPositiveInteger++;
        //     } else if (nums[i] > 0) {
        //         return missingPositiveInteger;
        //     }
        // }

        // return missingPositiveInteger;



        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }

        int missingPositiveInteger = 1;
        // for (int ele : set) {
        //     if(set.contains(missingPositiveInteger)) {
        //         missingPositiveInteger++;
        //     } else {
        //         return missingPositiveInteger;
        //     }
        // }

        while (set.contains(missingPositiveInteger)) {
            missingPositiveInteger++;
        }

        return missingPositiveInteger;
    }
}