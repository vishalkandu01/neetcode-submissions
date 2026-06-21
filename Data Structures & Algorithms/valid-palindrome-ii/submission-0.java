class Solution {
    private boolean solve(String s, int left, int right, boolean deleted) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) == s.charAt(right)) {
            return solve(s, left + 1, right - 1, deleted);
        }

        if (deleted) {
            return false;
        }

        return solve(s, left + 1, right, true)
                || solve(s, left, right - 1, true);
    }

    public boolean validPalindrome(String s) {
        return solve(s, 0, s.length() - 1, false);
    }
}