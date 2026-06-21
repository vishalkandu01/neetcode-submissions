class Solution {
    private boolean isAlphaNumeric(char ch) {
        if ((ch >= 'a' && ch <= 'z')
            || (ch >= 'A' && ch <= 'Z')
            || (ch >= '0' && ch <= '9')) {
            return true;
        }

        return false;
    }

    public boolean isPalindrome(String s) {
        // int i;
        // int n = s.length();
        // StringBuilder str = new StringBuilder();

        // for (i = 0; i < n; i++) {
        //     if (isAlphaNumeric(s.charAt(i))) {
        //         str.append(Character.toLowerCase(s.charAt(i)));
        //     }
        // }

        // i = 0;
        // n = str.length();
        // while (i < n / 2) {
        //     if (str.charAt(i) != str.charAt(n - 1 - i)) {
        //         return false;
        //     }
        //     i++;
        // }

        // return true;




        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))
                != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
