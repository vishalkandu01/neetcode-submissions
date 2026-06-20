class Solution {
    public int removeElement(int[] nums, int val) {
        // int len = nums.length;
        // int l = 0, r = len - 1;

        // while (l <= r) {
        //     if (nums[l] == val) {
        //         nums[l] = nums[r];
        //         r--;
        //     } else {
        //         l++;
        //     }
        // }
        // return l;

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // nums[k] = nums[i];
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
        return k;
    }
}