class Solution {
    private int countFrom(int nums[], int index, int sum, int k) {
        if (index == nums.length) {
            return 0;
        }

        sum += nums[index];
        int count = (sum == k) ? 1 : 0;

        return count + countFrom(nums, index + 1, sum, k);
    }

    private int countAll(int[] nums, int start, int k) {
        if (start == nums.length) {
            return 0;
        }

        return countFrom(nums, start, 0, k) + countAll(nums, start + 1, k);
    }

    public int subarraySum(int[] nums, int k) {
        // return countAll(nums, 0, k);


        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}