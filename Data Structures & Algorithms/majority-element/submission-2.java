class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer, Integer> hashMap = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        // }
        // for (HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
        //     if (entry.getValue() > nums.length / 2) {
        //         return entry.getKey();
        //     }
        // }
        // return -1;


        int candidate = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}