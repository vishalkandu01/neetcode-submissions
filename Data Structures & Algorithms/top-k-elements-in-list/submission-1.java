class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> arr = new ArrayList<>(hashMap.keySet());
        arr.sort((a, b) -> hashMap.get(b) - hashMap.get(a));
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}
