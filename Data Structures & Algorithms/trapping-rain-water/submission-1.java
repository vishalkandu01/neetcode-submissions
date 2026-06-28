class Solution {
    public int trap(int[] height) {
        // int n = height.length;
        // int[] prefixMaxHeight = new int[n];
        // int[] suffixMaxHeight = new int[n];

        // prefixMaxHeight[0] = height[0];
        // for (int i = 1; i < n; i++) {
        //     prefixMaxHeight[i] = Math.max(height[i], prefixMaxHeight[i - 1]);
        // }

        // suffixMaxHeight[n - 1] = height[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     suffixMaxHeight[i] = Math.max(height[i], suffixMaxHeight[i + 1]);
        // }

        // int trapWater = 0;
        // for (int i = 0; i < n; i++) {
        //     trapWater += Math.min(prefixMaxHeight[i], suffixMaxHeight[i]) - height[i];
        // }

        // return trapWater;




        int s = 0, e = height.length - 1;
        int leftMax = height[s];
        int rightMax = height[e];
        int res = 0;

        while (s < e) {
            if (leftMax <= rightMax) {
                res += leftMax - height[s];
                s++;
                leftMax = Math.max(leftMax, height[s]);
            } else {
                res += rightMax - height[e];
                e--;
                rightMax = Math.max(rightMax, height[e]);
            }
        }

        return res;
    }
}
