class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int t = 0;
            for (int pile : piles) {
                t += (pile + mid - 1) / mid;
            }
            if (t <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}