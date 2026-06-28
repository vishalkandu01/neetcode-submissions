class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int h = 0;
        int n = s.length() - 1;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (h <= n) {
            if (!set.contains(s.charAt(h))) {
                set.add(s.charAt(h));
                maxLength = Math.max(maxLength, h - l + 1);
                h++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }

        return maxLength;
    }
}
