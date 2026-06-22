class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        StringBuilder str = new StringBuilder();
        int i = 0;
        int j = 0;
        
        while (i < n && j < m) {
            if (i <= j) {
                str.append(word1.charAt(i++));
            } else {
                str.append(word2.charAt(j++));
            }
        }

        while (i < n) {
            str.append(word1.charAt(i++));
        }

        while (j < m) {
            str.append(word2.charAt(j++));
        }

        return str.toString();
    }
}