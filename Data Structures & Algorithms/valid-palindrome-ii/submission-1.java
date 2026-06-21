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


    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public boolean validPalindrome(String s) {
        // return solve(s, 0, s.length() - 1, false);




        int left  = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right)
                        || isPalindrome(s, left, right - 1);
            }
            
            left++;
            right--;
        }

        return true;
    }
}