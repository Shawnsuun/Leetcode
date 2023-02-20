class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //The range of speed is from 1 to max value in piles
        int left = 1;
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            //time out, speed up
            if (getTime(piles, mid) > h) {
                left = mid + 1;
            //can eat up, slow down
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //helper method to calculate the eat time in a given speed and piles
    private long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            time += (long) (pile - 1) / speed + 1;
        }
        return time;
    }
}