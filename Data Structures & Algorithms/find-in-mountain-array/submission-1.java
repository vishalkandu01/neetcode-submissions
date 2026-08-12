/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private int findPeakIndex(MountainArray mountainArr) {
        int s = 0;
        int len = mountainArr.length();
        int e = len - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid + 1 <= e && mid - 1 >= 0 && mountainArr.get(mid + 1) > mountainArr.get(mid)) {
                s = mid + 1;
            } else if (mid - 1 >= 0 && mountainArr.get(mid - 1) > mountainArr.get(mid)) {
                e = mid - 1;
            } else {
                return mid;
            }
        }

        return mountainArr.get(0) > mountainArr.get(len - 1) ? 0 : len - 1;
    }

    private int binarySearch(MountainArray mountainArr, int s, int e, int target) {
        if (mountainArr.get(s) < mountainArr.get(e)) {
            while (s <= e) {
                int mid = s + (e - s) / 2;
                int value = mountainArr.get(mid);
                if (value == target) {
                    return mid;
                } else if (value < target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        } else {
            while (s <= e) {
                int mid = s + (e - s) / 2;
                int value = mountainArr.get(mid);
                if (value == target) {
                    return mid;
                } else if (value > target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }

        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);
        if (peakIndex == -1) return -1;

        int leftIndex = binarySearch(mountainArr, 0, peakIndex, target);
        if (leftIndex != -1) return leftIndex;

        int rightIndex = binarySearch(mountainArr, peakIndex + 1, mountainArr.length() - 1, target);
        return rightIndex;
    }
}