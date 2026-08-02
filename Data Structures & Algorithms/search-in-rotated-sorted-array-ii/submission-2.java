class Solution {
    private boolean binarySearch(int[] nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[s] == nums[mid] && nums[mid] == nums[e]) {
                s++;
                e--;
                continue;
            }

            if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target < nums[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}