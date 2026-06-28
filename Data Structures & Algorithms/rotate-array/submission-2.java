class Solution {
    public void rotate(int[] nums, int k) {
        // int n = nums.length;
        // k = k % n;
        // if (k == 0) return;
        // int[] temp = new int[n];

        // for (int i = 0; i < n - k; i++) {
        //     temp[k + i] = nums[i];
        // }

        // for (int i = n - k; i < n; i++) {
        //     temp[i - n + k] = nums[i];
        // }
        
        // for (int i = 0; i < n; i++) {
        //     nums[i] = temp[i];
        // }

        // return;



        int n = nums.length;
        k = k % n;
        int s = 0, e = n - 1;

        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }

        s = 0; e = k - 1;
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }

        s = k; e = n - 1;
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
        
        return;
    }
}