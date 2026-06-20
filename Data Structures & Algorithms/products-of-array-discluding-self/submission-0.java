class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int countOfZero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                countOfZero++;
            }
        }

        int[] res = new int[n];

        if (countOfZero > 1) {
            return res;
        }

        if (countOfZero == 1) {
            int product = 1;
            int zeroElementPosition = -1;
            for (int i = 0; i < n; i++) {
                if (nums[i] != 0) {
                    product *= nums[i];
                } else {
                    zeroElementPosition = i;
                }
            }
            res[zeroElementPosition] = product;
            return res;
        }

        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            res[i] = product / nums[i];
        }

        return res;
    }
}  
