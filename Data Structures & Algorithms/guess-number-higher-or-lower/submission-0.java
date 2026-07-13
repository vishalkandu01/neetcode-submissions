/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int h = n;
        int mid = l + (h - l) / 2;
        while (l <= h) {
            int num = guess(mid);
            System.out.println(num);
            if (num == 0) return mid;
            else if (num == 1) l = mid + 1;
            else h = mid - 1;
            mid = l + (h - l) / 2;
        }

        return -1;
    }
}