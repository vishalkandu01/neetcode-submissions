class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int l = 0;
        int maxf = 0;
        int maxLength = 0;

        for (int h = 0; h < n; h++) {
            map.put(s.charAt(h), map.getOrDefault(s.charAt(h), 0) + 1);
            maxf = Math.max(map.get(s.charAt(h)), maxf);

            while ((h - l + 1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            maxLength = Math.max(h - l + 1, maxf);
        }

        return maxLength;
    }
}
