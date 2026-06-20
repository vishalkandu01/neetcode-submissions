class Solution {
    public int removeElement(int[] nums, int val) {
        // int cnt = 0;
        int len = nums.length;
        int l = 0, r = len - 1;

        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                r--;
            } else {
                l++;
            }
        }
        return l;
    }
}