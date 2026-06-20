class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] hashS = new int[26];
        int[] hashT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hashS[s.charAt(i) - 'a']++;
            hashT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (hashS[i] != hashT[i]) {
                return false;
            }
        }

        return true;
    }
}
