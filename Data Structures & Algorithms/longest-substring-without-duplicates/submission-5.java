class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int l = 0;
        // int h = 0;
        // int n = s.length() - 1;
        // int maxLength = 0;
        // Set<Character> set = new HashSet<>();

        // while (h <= n) {
        //     if (!set.contains(s.charAt(h))) {
        //         set.add(s.charAt(h));
        //         maxLength = Math.max(maxLength, h - l + 1);
        //         h++;
        //     } else {
        //         set.remove(s.charAt(l));
        //         l++;
        //     }
        // }

        // return maxLength;



        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int maxLength = 0;

        for (int h = 0; h < n; h++) {
            if (!map.containsKey(s.charAt(h))) {
                map.put(s.charAt(h), h);
            } else {
                l = Math.max(l, map.get(s.charAt(h)) + 1);
                map.put(s.charAt(h), h);
            }
            
            maxLength = Math.max(h - l + 1, maxLength);
        }

        return maxLength;
    }
}
