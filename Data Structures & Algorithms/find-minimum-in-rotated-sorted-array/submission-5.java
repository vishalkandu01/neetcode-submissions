class Solution {
    public int findMin(int[] nums) {
        // int mini = 1001;
        
        // for (int i = 0; i < nums.length; i++) {
        //     mini = Math.min(mini, nums[i]);
        // }

        // return mini;



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

        return nums[e];
    }
}
