class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;

        int required = mapT.size();
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        
        while (r < s.length()) {
            char ch = s.charAt(r);

            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);

            if (mapT.containsKey(ch) &&
                mapS.get(ch).intValue() == mapT.get(ch).intValue()) {
                formed++;
            }

            while (required == formed) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);

                mapS.put(leftChar, mapS.get(leftChar) - 1);

                if (mapT.containsKey(leftChar) &&
                    mapS.get(leftChar) < mapT.get(leftChar)) {
                    formed--;
                }

                l++;
            }
            r++;
        }

        return minLength == Integer.MAX_VALUE ? ""
                            : s.substring(start, start + minLength);
    }
}