class Solution {
    public int findDuplicate(int[] nums) {
        // ArrayList<Integer> arr = new ArrayList<>(Collections.nCopies(nums.length, 0));

        // for (int num : nums) {
        //     arr.set(num, arr.get(num) + 1);
        //     if (arr.get(num) > 1) return num;
        // }

        // return -1;



        // int[] arr = new int[nums.length];

        // for (int i = 0; i < nums.length; i++) {
        //     if (arr[nums[i]] > 0) return nums[i];
        //     arr[nums[i]] += 1;
        // }

        // return -1;



        // Phase 1: Find intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance of cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}