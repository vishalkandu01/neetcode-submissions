class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (char ch : s1.toCharArray()) {
            need[ch - 'a']++;
        }

        int l = 0;

        for (int h = 0; h < n2; h++) {
            window[s2.charAt(h) - 'a']++;

            if (h - l + 1 > n1) {
                window[s2.charAt(l) - 'a']--;
                l++;
            }

            if (h - l + 1 == n1) {
                boolean s2ContainS1 = true;
                for (int i = 0; i < 26; i++) {
                    if (need[i] != window[i]) {
                        s2ContainS1 = false;
                        break;
                    }
                }
                if(s2ContainS1) return true;
            }
        }

        return false;
    }
}
