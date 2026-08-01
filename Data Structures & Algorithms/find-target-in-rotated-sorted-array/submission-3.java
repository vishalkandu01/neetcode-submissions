class Solution {
    private int searchPivotIndex(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        
        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] > nums[e]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }

    private int binarySearch(int[] nums, int s, int e, int target) {
        while (s <= e) {
                int mid = s + (e - s) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < target) s = mid + 1;
                else e = mid - 1;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int pivotIndex = searchPivotIndex(nums);

        if (pivotIndex == 0) {
            return binarySearch(nums, s, e, target);
        } else if (target >= nums[0] && target <= nums[pivotIndex - 1]) {
            return binarySearch(nums, s, pivotIndex - 1, target);
        } else if (target >= nums[pivotIndex] && target <= nums[e]) {
            return binarySearch(nums, pivotIndex, e, target);
        }

        return -1;
    }
}
