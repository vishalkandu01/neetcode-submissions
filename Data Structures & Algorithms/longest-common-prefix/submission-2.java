class Solution {
    public String longestCommonPrefix(String[] strs) {
        int t = strs[0].length(), cnt = 0;
        while (t > 0) {
            boolean breakOuterLoop = false;
            int ch = strs[0].charAt(cnt);
            for (int i = 1; i < strs.length; i++) {
                if (cnt >= strs[i].length() || ch != strs[i].charAt(cnt)) {
                    breakOuterLoop = true;
                    break;
                }
            }
            if (breakOuterLoop == true) {
                break;
            }
            cnt++;
            t--;
        }

        // String resStr = "";
        // for (int i = 0; i < cnt; i++) {
        //     resStr += strs[0].charAt(i);
        // }
        // return resStr;

        return strs[0].substring(0, cnt);
    }
}