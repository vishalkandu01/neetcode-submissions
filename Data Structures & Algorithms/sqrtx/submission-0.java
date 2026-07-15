class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        
        int l = 2;
        int h = x;
        int mid = l + (h - l) / 2;

        while (l <= h) {
            if (mid == x / mid) return mid;
            else if (mid < x / mid) l = mid + 1;
            else h = mid - 1;
            mid = l + (h - l) / 2;
        }

        return h;
    }
}